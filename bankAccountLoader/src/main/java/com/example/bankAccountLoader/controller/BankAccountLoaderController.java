package com.example.bankAccountLoader.controller;

import com.example.bankAccountLoader.model.*;
import com.example.bankAccountLoader.service.BankAccountLoaderService;
import com.example.bankAccountLoader.service.KafkaConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/bankAccountLoader")
@AllArgsConstructor
public class BankAccountLoaderController {

    private RestTemplate restTemplate;

    @Autowired
    private KafkaConsumerService consumer;

    @Autowired
    private BankAccountLoaderService service;

    public BankAccountLoaderController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public TechResponse saveBankAccount(){
        try {
            String url = "http://localhost:8080/bankAccountGenerator/";
            ResponseEntity<BankAccount> response = restTemplate.getForEntity(url, BankAccount.class);
            return service.saveAccount(consumer.getLatestBankAccount());
        }catch (Exception ex){
            return new TechResponse("ERROR","Ошибка получения данных от сервиса генерации аккаунтов");
        }


    }


}
