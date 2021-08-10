package com.maganets.kafkaproducer.service;

import com.maganets.kafkaproducer.entity.store.StoreOrderWrapper;
import com.maganets.kafkaproducer.gateway.FreedomLogGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FreedomStoreService {

  private final FreedomLogGateway freedomLogGateway;
  private final KafkaTemplate<String, StoreOrderWrapper> kafkaTemplate;

  @Value("${kafka.topic.freedom.store}")
  private String topicFreedomStore;

  public StoreOrderWrapper createFreedomStore(final StoreOrderWrapper wrapper) {
    try {
      log.info(
          "Sending store data to kafka: Store ID {}, Order Number {}",
          wrapper.getStoreId(),
          wrapper.getOrderInfo().getOrderNumber());
      freedomLogGateway.saveStoreWrapper(wrapper);
      kafkaTemplate.send(topicFreedomStore, wrapper.getUuid(), wrapper).get();
      return wrapper;
    } catch (Exception e) {
      log.error("Error sending kafka message", e);
      return null;
    }
  }
}
