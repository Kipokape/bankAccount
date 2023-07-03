package com.example.bankAccountLoader;

import com.example.bankAccountLoader.model.*;
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
    private BankAccountLoaderService service;

    public BankAccountLoaderController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public TechResponse saveBankAccount(){
        try {
            String url = "http://localhost:8080/bankAccountGenerator/";
            ResponseEntity<BankAccount> response = restTemplate.getForEntity(url, BankAccount.class);
            return service.saveAccount(response.getBody());
        }catch (Exception ex){
            return new TechResponse("ERROR","Ошибка получения данных от сервиса генерации аккаунтов");
        }


    }


}
