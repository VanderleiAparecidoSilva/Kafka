package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StorePaymentResume implements Serializable {

  private String paymentType;

  @NotNull(message = "O CAMPO 'RESUMO DO PAGAMENTO - VALOR' NÃO DEVE SER NULO")
  private BigDecimal value;

  private Integer numberOfInstallments;
}
