package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StoreItemGroupSummary implements Serializable {

  private String groupInventoryReserve;

  private List<StoreUnitPrice> unitPriceList;

  private Integer groupQuantity;
  private BigDecimal groupGrossPrice;
  private BigDecimal groupDiscountNcard;
  private BigDecimal groupDiscountWithoutNcard;
  private BigDecimal groupNetPrice;
}
