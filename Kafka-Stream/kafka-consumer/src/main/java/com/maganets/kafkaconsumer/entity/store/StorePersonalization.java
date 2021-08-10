package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class StorePersonalization implements Serializable {

  private String personaDescription;
  private String personaSku;
  private BigDecimal personaValue;
}
