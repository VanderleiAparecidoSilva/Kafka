package com.maganets.kafkaconsumer.gateway.mongodb;

import com.maganets.kafkaconsumer.entity.log.LogZattStore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreedomZattRepository extends MongoRepository<LogZattStore, String> {}
