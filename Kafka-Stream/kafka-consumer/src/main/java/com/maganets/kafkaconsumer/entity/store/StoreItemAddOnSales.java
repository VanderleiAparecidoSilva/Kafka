package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StoreItemAddOnSales implements Serializable {

  private List<StoreUnitAddOnSalesSummary> unitAddOnSalesSummaryList;
  private BigDecimal addOnSalesGrossPrice;
  private BigDecimal addOnSalesNetPrice;
  private BigDecimal addOnSalesDiscountNcard;
  private BigDecimal addOnSalesDiscountWithoutNcard;
}
