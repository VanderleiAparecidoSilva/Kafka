package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StoreUnitPrice implements Serializable {

  @NotNull(message = "O CAMPO 'PRECO UNITARIO - DESCONTO NCARD' NÃO DEVE SER NULO")
  private BigDecimal unitPriceDiscountNcard;

  @NotNull(message = "O CAMPO 'PRECO UNITARIO - DESCONTO' NÃO DEVE SER NULO")
  private BigDecimal unitPriceDiscountWithoutNcard;

  @NotNull(message = "O CAMPO 'PRECO UNITARIO - PREÇO BRUTO' NÃO DEVE SER NULO")
  private BigDecimal unitPriceGrossPrice;

  @NotNull(message = "O CAMPO 'PRECO UNITARIO - PREÇO LIQUIDO' NÃO DEVE SER NULO")
  private BigDecimal unitPriceNetPrice;

  private StoreItemAddOnSales addOnSalesSummary;
}
