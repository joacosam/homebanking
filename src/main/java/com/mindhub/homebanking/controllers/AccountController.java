package com.mindhub.homebanking.controllers;


import com.mindhub.homebanking.dtos.AccountDto;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}