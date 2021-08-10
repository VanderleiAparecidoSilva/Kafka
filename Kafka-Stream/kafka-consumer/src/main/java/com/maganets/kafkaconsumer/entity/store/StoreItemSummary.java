package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StoreItemSummary implements Serializable {

  @NotNull(message = "O CAMPO 'RESUMO DO ITEM - QUANTIDADE TOTAL' NÃO DEVE SER NULO")
  private Integer totalQuantity;

  @NotNull(message = "O CAMPO 'RESUMO DO ITEM - DESCONTO NCARD' NÃO DEVE SER NULO")
  private BigDecimal totalDiscountNcard;

  @NotNull(message = "O CAMPO 'RESUMO DO ITEM - DESCONTO' NÃO DEVE SER NULO")
  private BigDecimal totalDiscountWithoutNcard;

  @NotNull(message = "O CAMPO 'RESUMO DO ITEM - PREÇO TOTAL BRUTO' NÃO DEVE SER NULO")
  private BigDecimal totalGrossPrice;

  @NotNull(message = "O CAMPO 'RESUMO DO ITEM - PREÇO TOTAL LIQUIDO' NÃO DEVE SER NULO")
  private BigDecimal totalNetPrice;

  private List<StoreItem> items;
}
