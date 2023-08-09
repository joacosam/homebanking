package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDto;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @RequestMapping(value = "/client")
    public List<ClientDto> getClients(){
        List<Client> listClient = clientRepository.findAll();
        return listClient.stream().map(ClientDto::new).collect(Collectors.toList());
    };
    @RequestMapping("/clients/{id}")
    public ClientDto getById(@PathVariable Long id) {
        return new ClientDto(clientRepository.findById(id).orElse(null));
    }



}