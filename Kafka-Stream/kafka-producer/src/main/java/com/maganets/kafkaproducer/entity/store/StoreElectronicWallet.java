package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StoreElectronicWallet implements Serializable {

  private String token;
  private String gateway;
  private String type;
}
