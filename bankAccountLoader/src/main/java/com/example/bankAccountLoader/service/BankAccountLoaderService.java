package com.example.bankAccountLoader.service;


import com.example.bankAccountLoader.model.*;
import com.example.bankAccountLoader.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountLoaderService {

    @Autowired
    BankAccountRepository repository;


    public TechResponse saveAccount(BankAccount account){

        if(account==null) return new TechResponse("ERROR","Ошибка получения данных из Kafka");

        if(findAccount(account)){
            return new TechResponse("ERROR","Аккаунт уже зарегистрирован в БД");
        }else {
            repository.save(account);
        }
        return new TechResponse("SUCCESS","null");
    }

    private boolean findAccount(BankAccount account){
        return repository.findById(account.getUuid()).isPresent() || repository.findByAccountNumber(account.getAccountNumber()).isPresent();
    }
}
