package com.maganets.kafkaconsumer.entity.log;

import com.maganets.kafkaconsumer.entity.store.StoreOrderWrapper;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "zattStore")
@Builder
public class LogZattStore {

  @Id private String uuid;
  private StoreOrderWrapper storeWrapper;
  private LocalDateTime integrationDate;
}
