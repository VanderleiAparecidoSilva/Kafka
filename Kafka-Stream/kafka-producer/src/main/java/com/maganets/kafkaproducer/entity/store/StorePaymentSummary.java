package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StorePaymentSummary implements Serializable {

  @NotNull(message = "O CAMPO 'RESUMO DO PAGAMENTO - DESCONTO NCARD' NÃO DEVE SER NULO")
  private BigDecimal totalPaymentsValue;

  private List<StorePaymentResume> paymentList;
}
