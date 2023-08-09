package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountDto {
    private Long id;
    private String number;
    private Double balance;
    private LocalDate date;

    public AccountDto(Account account){
        id = account.getId();
        number = account.getNumber();
        balance = account.getBalance();
        date = account.getCreationDate();
    }
    public Long getId() { return id;}

    public String getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public LocalDate getDate() {
        return date;
    }
}
