package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StoreUnitAddOnSalesSummary implements Serializable {

  private ProductAddOnSalesType unitAddOnSalesType;
  private BigDecimal unitAddOnSalesGrossPrice;
  private BigDecimal unitAddOnSalesDiscountNcard;
  private BigDecimal unitAddOnSalesDiscountWithoutNcard;
  private BigDecimal unitAddOnSalesNetPrice;
}
