package com.maganets.kafkaproducer.entity.log;

import com.maganets.kafkaproducer.entity.store.StoreCustomer;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "storeCustomer")
@Builder
public class LogStoreCustomer {

  @Id private String uuid;
  private StoreCustomer storeCustomer;
  private LocalDateTime integrationDate;
}
