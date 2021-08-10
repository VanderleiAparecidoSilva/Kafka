package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StorePromotion implements Serializable {

  private String id;

  private Boolean optin;
}
