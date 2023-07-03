package com.example.bankAccountGenerator.controller;

import com.example.bankAccountGenerator.model.BankAccount;
import com.example.bankAccountGenerator.service.BankAccountGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankAccountGenerator")
@AllArgsConstructor
public class BankAccountGeneratorController {

    @Autowired
    KafkaTemplate<Long,BankAccount> kafkaTemplate;

    private static final String TOPIC = "bank-account-topic";

    private final BankAccountGeneratorService service;

    @GetMapping("/")
    public BankAccount getRandomGeneratedAccount(){

        BankAccount res = service.generateRandomAccount();

        kafkaTemplate.send(TOPIC, res);
        return res;
    }


}
