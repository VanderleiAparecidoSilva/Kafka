package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StoreShippingSummary implements Serializable {

  @NotNull(message = "O CAMPO 'RESUMO DA ENTREGA - TOTAL LIQUIDO DA ENTREGA' NÃO DEVE SER NULO")
  private BigDecimal totalNetShipping;

  private List<StoreShippingResume> shippingList;
}
