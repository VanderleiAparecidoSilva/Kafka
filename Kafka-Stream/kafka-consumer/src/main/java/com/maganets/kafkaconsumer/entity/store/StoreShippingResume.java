package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class StoreShippingResume implements Serializable {

  private String id;

  private String sellerID = "0";

  @NotNull(message = "O CAMPO 'ENTREGA LOJA - VALOR LIQUIDO DA ENTREGA' NÃO DEVE SER NULO")
  private BigDecimal shippingNetValue;
}
