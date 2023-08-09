package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;


public class ClientDto {
    private final Long id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private Set<AccountDto> accountDto;
    public ClientDto(Client client){
        this.id = client.getId();

        this.firstName = client.getFirstName();

        this.lastName = client.getLastName();

        this.email = client.getEmail();

        accountDto = client.getAccounts().stream().map(element -> new AccountDto(element)).collect(Collectors.toSet());

    }





    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public Set<AccountDto> getAccounts(){
        return accountDto;
    }
}