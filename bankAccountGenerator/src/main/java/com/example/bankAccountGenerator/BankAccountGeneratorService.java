package com.example.bankAccountGenerator;


import com.example.bankAccountGenerator.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class BankAccountGeneratorService {

    @Autowired
    FileDataReader filesData;

    public BankAccount generateRandomAccount(){
        Random random = new Random();
        UUID UUID = java.util.UUID.randomUUID();
        long accountNumber = Math.abs(random.nextLong());
        String name;
        String lastName;
        String patronymic;

        if(random.nextBoolean()){
            name = filesData.getMansNames().get(random.nextInt(filesData.getMansNames().size()));
            lastName = filesData.getMansSurnames().get(random.nextInt(filesData.getMansSurnames().size()));
            patronymic = filesData.getMansPatronymics().get(random.nextInt(filesData.getMansPatronymics().size()));
        }
        else {
            name = filesData.getWomansNames().get(random.nextInt(filesData.getWomansNames().size()));
            lastName = filesData.getWomansSurnames().get(random.nextInt(filesData.getWomansSurnames().size()));
            patronymic = filesData.getWomansPatronymics().get(random.nextInt(filesData.getWomansPatronymics().size()));
        }
        return new BankAccount(UUID,name,lastName,patronymic,accountNumber);
    }



}
