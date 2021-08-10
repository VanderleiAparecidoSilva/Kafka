package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class StoreBillingSlip implements Serializable {

  private String number;
  private BigDecimal value;
  private String issuer;
}
