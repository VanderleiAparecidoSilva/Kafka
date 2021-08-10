package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

@Component
@Getter
@Setter
@ToString
public class StoreOrderWrapper implements Serializable {
  private String uuid;
  private String storeId;
  private StoreCustomer customer;
  private StoreOrder orderInfo;

  public OrderType orderType() {
    OrderType type;
    final long netshoesCount =
        this.orderInfo.getProducts().stream()
            .map(StoreProduct::getSellerID)
            .map(StringUtils::trimToNull)
            .map(Optional::ofNullable)
            .map(this::isNetshoes)
            .filter(Boolean::booleanValue)
            .count();

    if (this.orderInfo.getProducts().size() == netshoesCount) {
      type = OrderType.NETSHOES;
    } else if (netshoesCount == 0) {
      type = OrderType.MARKETPLACE;
    } else {
      type = OrderType.MISTO;
    }
    return type;
  }

  private boolean isNetshoes(final Optional<String> sellerIdOpt) {
    return sellerIdOpt.map("0"::equals).orElse(true);
  }
}
