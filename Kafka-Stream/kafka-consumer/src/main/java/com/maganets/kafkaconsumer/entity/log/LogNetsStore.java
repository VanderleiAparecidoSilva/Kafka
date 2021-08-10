package com.maganets.kafkaconsumer.entity.log;

import com.maganets.kafkaconsumer.entity.krecord.KRecord;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "netsStore")
@Builder
public class LogNetsStore {

  @Id private String uuid;
  private KRecord storeWrapper;
  private LocalDateTime integrationDate;
}
