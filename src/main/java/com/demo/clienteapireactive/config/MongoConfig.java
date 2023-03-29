package com.demo.clienteapireactive.config;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories( basePackages = "com.demo.clienteapireactive.repository")


public class MongoConfig extends AbstractReactiveMongoConfiguration{

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(); }

    @Override
    protected String getDatabaseName() {
        return "evalDb"; }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());

    }
}
