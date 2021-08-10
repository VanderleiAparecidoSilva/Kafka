package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class StoreItem implements Serializable {

  private String sku;

  private String sellerID = "0";

  private String uuid = StringUtils.EMPTY;

  @NotNull(message = "O CAMPO 'ITEM LOJA - QUANTIDADE' NÃO DEVE SER NULO")
  private Integer itemQuantity = 1;

  @NotNull(message = "O CAMPO 'ITEM LOJA - DESCONTO NCARD' NÃO DEVE SER NULO")
  private BigDecimal itemDiscountNcard;

  @NotNull(message = "O CAMPO 'ITEM LOJA - DESCONTO' NÃO DEVE SER NULO")
  private BigDecimal itemDiscountWithoutNcard;

  @NotNull(message = "O CAMPO 'ITEM LOJA - PREÇO TOTAL BRUTO' NÃO DEVE SER NULO")
  private BigDecimal itemGrossPrice;

  @NotNull(message = "O CAMPO 'ITEM LOJA - PREÇO TOTAL LIQUIDO' NÃO DEVE SER NULO")
  private BigDecimal itemNetPrice;

  private List<StoreItemGroupSummary> itemGroupSummaryList;
}
