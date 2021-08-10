package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class StoreOnline implements Serializable {

  private String gateway;
  private Integer installmentsNumber;
  private BigDecimal value;
}
