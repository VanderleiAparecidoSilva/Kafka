package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StoreOrderSummary implements Serializable {

  @NotNull(message = "O CAMPO 'DESCONTO NCARD' NÃO DEVE SER NULO")
  private BigDecimal totalDiscountNcard;

  @NotNull(message = "O CAMPO 'DESCONTO' NÃO DEVE SER NULO")
  private BigDecimal totalDiscountWithoutNcard;

  @NotNull(message = "O CAMPO 'PREÇO BRUTO DO PEDIDO' NÃO DEVE SER NULO")
  private BigDecimal totalGrossPrice;

  @NotNull(message = "O CAMPO 'PREÇO LIQUIDO DO PEDIDO' NÃO DEVE SER NULO")
  private BigDecimal totalNetPrice;

  private StoreItemSummary itemsSummary;

  private StoreShippingSummary shippingSummary;

  private StorePaymentSummary paymentsSummary;
}
