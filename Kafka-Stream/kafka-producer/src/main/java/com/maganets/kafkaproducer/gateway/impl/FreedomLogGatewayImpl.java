package com.maganets.kafkaproducer.gateway.impl;

import com.maganets.kafkaproducer.entity.log.LogStoreWrapper;
import com.maganets.kafkaproducer.entity.store.StoreOrderWrapper;
import com.maganets.kafkaproducer.gateway.FreedomLogGateway;
import com.maganets.kafkaproducer.gateway.repository.mongodb.FreedomStoreWrapperLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FreedomLogGatewayImpl implements FreedomLogGateway {

  private final FreedomStoreWrapperLogRepository freedomStoreWrapperLogRepository;

  @Override
  public LogStoreWrapper saveStoreWrapper(final StoreOrderWrapper storeOrderWrapper) {
    return freedomStoreWrapperLogRepository.save(buildStoreWrapperLog(storeOrderWrapper));
  }

  private LogStoreWrapper buildStoreWrapperLog(final StoreOrderWrapper storeOrderWrapper) {
    return LogStoreWrapper.builder()
        .uuid(storeOrderWrapper.getUuid())
        .storeWrapper(storeOrderWrapper)
        .integrationDate(LocalDateTime.now())
        .build();
  }
}
