package com.maganets.kafkaproducer.entity.store;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StorePurchaseVoucher implements Serializable {

  private String code;
  private BigDecimal valueUsed;
}
