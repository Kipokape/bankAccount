package com.example.bankAccountLoader.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Column(unique = true)
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymic;
    @Id
    private long accountNumber;

}
