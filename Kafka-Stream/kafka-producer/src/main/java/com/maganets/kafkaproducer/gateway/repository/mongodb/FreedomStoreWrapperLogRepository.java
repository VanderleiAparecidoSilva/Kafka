package com.maganets.kafkaproducer.gateway.repository.mongodb;

import com.maganets.kafkaproducer.entity.log.LogStoreWrapper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreedomStoreWrapperLogRepository extends MongoRepository<LogStoreWrapper, String> {}
