package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class StoreProduct implements Serializable {

  private String sku;
  private String sellerID;
  private String uuid = StringUtils.EMPTY;

  @NotNull(message = "O CAMPO 'PREÇO UNITÁRIO DO ITEM' NÃO DEVE SER NULO")
  private BigDecimal unitPrice;

  private BigDecimal unitDiscount;
  private BigDecimal unitDiscountNCard;

  @NotNull(message = "O CAMPO 'QUANTIDADE DO ITEM' NÃO DEVE SER NULO")
  private Integer quantity;

  private Boolean gift;
  private Boolean freebie;
  private BigDecimal giftValue;
  private List<StorePersonalization> personalizations;
  private List<StoreRewardPoint> programs;
  private String uidReserve;
  private List<String> uidReserveUnityList;

  public BigDecimal getUnitNetPrice() {
    return ObjectUtils.defaultIfNull(unitPrice, BigDecimal.ZERO)
        .subtract(ObjectUtils.defaultIfNull(unitDiscount, BigDecimal.ZERO));
  }

  public Map<String, StoreRewardPoint> getPointMap() {
    Map<String, StoreRewardPoint> pointMap = null;
    if (this.programs != null) {
      pointMap = new HashMap<>();
      for (StoreRewardPoint point : this.programs) {
        pointMap.put(this.sku, point);
      }
    }

    return pointMap;
  }

  public boolean hasPersonalizations() {
    return !CollectionUtils.isEmpty(this.personalizations);
  }
}
