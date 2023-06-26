package com.example.bankAccountLoader;


import com.example.bankAccountLoader.model.BankAccount;
import com.example.bankAccountLoader.model.TechResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountLoaderService {

    @Autowired
    BankAccountRepository repository;


    public TechResponse saveAccount(BankAccount account){

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
