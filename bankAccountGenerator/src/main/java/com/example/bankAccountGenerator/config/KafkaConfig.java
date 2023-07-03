package com.example.bankAccountGenerator.config;


import com.example.bankAccountGenerator.model.BankAccount;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private static final String TOPIC_NAME = "bank-account-topic";

    private static final String kafkaServer = "localhost:29092";
    private static final int NUM_PARTITIONS = 2;
    private static final short REPLICATION_FACTOR = 1;

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name(TOPIC_NAME)
                .partitions(NUM_PARTITIONS)
                .replicas(REPLICATION_FACTOR)
                .build();
    }

    @Bean
    public ProducerFactory<Long, BankAccount> producerFactory(){

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean
    public KafkaTemplate<Long,BankAccount> kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());
    }


}
