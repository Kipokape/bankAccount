package com.example.bankAccountLoader.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    @Column(unique = true)
    private long accountNumber;

}
