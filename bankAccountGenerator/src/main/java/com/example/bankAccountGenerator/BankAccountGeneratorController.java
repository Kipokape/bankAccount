package com.example.bankAccountGenerator;

import com.example.bankAccountGenerator.model.BankAccount;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankAccountGenerator")
@AllArgsConstructor
public class BankAccountGeneratorController {
    @Autowired
    private final BankAccountGeneratorService service;

    private final BankAccountGeneratorKafkaService producer;
    @GetMapping("/")
    public BankAccount getRandomGeneratedAccount(){

        BankAccount res = service.generateRandomAccount();
        producer.sendBankAccount(res);
        return res;
    }


}
