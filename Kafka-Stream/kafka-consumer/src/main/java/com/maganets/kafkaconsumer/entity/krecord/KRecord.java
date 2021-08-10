package com.maganets.kafkaconsumer.entity.krecord;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KRecord {

  private String UUID;
  private String STOREID;
  private KCustomer CUSTOMER;
  private KOrder ORDERINFO;
}
