package com.maganets.kafkaproducer.entity.store;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maganets.kafkaproducer.config.json.LocalDateTimeDeserializer;
import com.maganets.kafkaproducer.entity.store.StoreAddress;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
public class StoreShipping implements Serializable {

  private String deliveryService;
  private String deliveryId;
  private Integer sellerID;
  private Integer deadline;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime scheduledDate;

  private Integer scheduledPeriod;
  private BigDecimal deliveryValue;
  private StoreAddress deliveryAddress;
  private StoreAddress referralAddress;
  private String cnpjPhysicalStore;
  private String customerNameRemovesPhysicalStore;
  private String idGroupFreightQuote;
  private String idFreightQuote;
  private String serviceName;
  private String customerDocumentRemovesPhysicalStore;
  private Integer storeCodeRemovesPhysicalStore;

  public boolean hasDeliveryAddress() {
    return Objects.nonNull(this.deliveryAddress);
  }

  public boolean hasReferralAddress() {
    return Objects.nonNull(this.referralAddress);
  }

  public boolean addReferralAddress() {
    return hasReferralAddress()
        && deliveryAddress.getState().equalsIgnoreCase(referralAddress.getState());
  }
}
