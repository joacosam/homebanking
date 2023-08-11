package com.mindhub.homebanking.controllers;


import com.mindhub.homebanking.dtos.AccountDto;
import com.mindhub.homebanking.dtos.TransactionDto;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @RequestMapping(value = "/accounts")
    public List<AccountDto> getAccount(){
        List<Account> listAccount = accountRepository.findAll();
        return listAccount.stream().map(AccountDto::new).collect(Collectors.toList());
    };
    @GetMapping
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            return null;
        }
        return convertToDto(account);
    }

    private AccountDto convertToDto(Account account) {
        AccountDto accountDTO = new AccountDto(account);

        List<TransactionDto> transactionDTOs = account.getTransactions().stream()
                .map(this::convertToTransactionDto)
                .collect(Collectors.toList());
        accountDTO.setTransactions(transactionDTOs);

        return accountDTO;
    }

    private TransactionDto convertToTransactionDto(Transaction transaction) {
        TransactionDto transactionDTO = new TransactionDto();
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setDate(transaction.getDate());
        return transactionDTO;
    }
}
