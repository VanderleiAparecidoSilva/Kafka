package com.maganets.kafkaproducer.entity.log;

import com.maganets.kafkaproducer.entity.store.StoreOrderWrapper;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "storeWrapper")
@Builder
public class LogStoreWrapper {

  @Id private String uuid;
  private StoreOrderWrapper storeWrapper;
  private LocalDateTime integrationDate;
}
