package com.example.bankAccountGenerator.model;

import lombok.Data;
import java.util.UUID;

@Data
public class BankAccount {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    private long accountNumber;

    public BankAccount(UUID uuid, String firstName, String lastName, String patronymic, long accountNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
    }
}
