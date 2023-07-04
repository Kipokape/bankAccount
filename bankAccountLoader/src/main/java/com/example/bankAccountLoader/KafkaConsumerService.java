package com.example.bankAccountLoader;


import com.example.bankAccountLoader.model.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {

    private static final String TOPIC = "bank-account-topic";

    private static final String groupId = "bankAccountLoader";

    private BankAccount latestBankAccount;


    @KafkaListener(topics = TOPIC, groupId = groupId)
    public void consume(ConsumerRecord<String,String> record) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        latestBankAccount = objectMapper.readValue(record.value(), BankAccount.class);

        System.out.println("Received message: " + record.value());


    }

    public BankAccount getLatestBankAccount() {
        return latestBankAccount;
    }
}
