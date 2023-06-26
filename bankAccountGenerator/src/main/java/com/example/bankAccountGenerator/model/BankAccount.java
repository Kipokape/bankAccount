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
}
