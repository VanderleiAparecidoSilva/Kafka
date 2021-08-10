package com.maganets.kafkaproducer.entity.log;

import com.maganets.kafkaproducer.entity.store.StoreOrder;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "storeOrder")
@Builder
public class LogStoreOrder {

  @Id private String uuid;
  private StoreOrder storeOrder;
  private LocalDateTime integrationDate;
}
