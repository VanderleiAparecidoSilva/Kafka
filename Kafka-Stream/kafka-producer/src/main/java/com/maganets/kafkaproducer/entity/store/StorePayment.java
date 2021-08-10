package com.maganets.kafkaproducer.entity.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StorePayment implements Serializable {

  private StorePaymentType typePayment;
  private boolean encrypted;
  private String origin;
  private StoreCardInformation card;
  private StoreBillingSlip billingSlip;
  private StorePurchaseVoucher coupon;
  private StoreOnline online;
}
