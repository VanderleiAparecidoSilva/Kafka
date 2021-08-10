package com.maganets.kafkaconsumer.gateway.impl;

import com.maganets.kafkaconsumer.entity.krecord.KRecord;
import com.maganets.kafkaconsumer.entity.log.LogNetsStore;
import com.maganets.kafkaconsumer.entity.log.LogZattStore;
import com.maganets.kafkaconsumer.entity.store.StoreOrderWrapper;
import com.maganets.kafkaconsumer.gateway.FreedomLogGateway;
import com.maganets.kafkaconsumer.gateway.mongodb.FreedomNetsRepository;
import com.maganets.kafkaconsumer.gateway.mongodb.FreedomZattRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FreedomLogGatewayImpl implements FreedomLogGateway {

  private final FreedomNetsRepository freedomNetsRepository;
  private final FreedomZattRepository freedomZattRepository;

  @Override
  public LogNetsStore saveNetsStore(final KRecord record) {
    return freedomNetsRepository.save(buildNetsStoreLog(record));
  }

  @Override
  public LogZattStore saveZattStore(final StoreOrderWrapper wrapper) {
    return freedomZattRepository.save(buildZattStoreLog(wrapper));
  }

  private LogNetsStore buildNetsStoreLog(final KRecord record) {
    return LogNetsStore.builder()
        .uuid(record.getUUID())
        .storeWrapper(record)
        .integrationDate(LocalDateTime.now())
        .build();
  }

  private LogZattStore buildZattStoreLog(final StoreOrderWrapper wrapper) {
    return LogZattStore.builder()
        .uuid(wrapper.getUuid())
        .storeWrapper(wrapper)
        .integrationDate(LocalDateTime.now())
        .build();
  }
}
