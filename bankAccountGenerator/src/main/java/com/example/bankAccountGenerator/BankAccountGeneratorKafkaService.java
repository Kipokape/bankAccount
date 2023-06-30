package com.example.bankAccountGenerator;


import com.example.bankAccountGenerator.model.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountGeneratorKafkaService {


    @Value("${topic.bank-account-topic}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendBankAccount(BankAccount bankAccount){
        kafkaTemplate.send(sendClientTopic, String.valueOf(bankAccount.getAccountNumber()), bankAccount);
    }

}
