package com.example.bankAccountGenerator;


import com.example.bankAccountGenerator.model.BankAccount;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
@RequiredArgsConstructor
public class Producer {
    @Autowired
    private final BankAccountGeneratorKafkaService kafkaService;

    private final ModelMapper modelMapper;

    public BankAccount sendOrderEvent(BankAccount bankAccount) {
        kafkaService.sendBankAccount(modelMapper.map(bankAccount, BankAccount.class));
        System.out.println("Send order from producer {}" +  bankAccount);
        return bankAccount;
    }

}
