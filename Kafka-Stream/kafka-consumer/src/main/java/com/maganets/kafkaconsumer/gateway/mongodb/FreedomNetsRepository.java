package com.maganets.kafkaconsumer.gateway.mongodb;

import com.maganets.kafkaconsumer.entity.log.LogNetsStore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreedomNetsRepository extends MongoRepository<LogNetsStore, String> {}
