package com.mindhub.homebanking.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String number;
    private LocalDate creationDate;
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="owner_id"  )
    private Client owner;
    public Account() { }

    public Account(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Account(String number, LocalDate creationDate, Double balance) {
        this.number = number;
        this.creationDate = creationDate;
        this.balance = balance;

    }
}