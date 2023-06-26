package com.example.bankAccountGenerator;

import com.example.bankAccountGenerator.model.BankAccount;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankAccountGenerator")
@AllArgsConstructor
public class BankAccountGeneratorController {

    private final BankAccountGeneratorService service;

    @GetMapping("/")
    public BankAccount getRandomGeneratedAccount(){
        return service.generateRandomAccount();
    }


}
