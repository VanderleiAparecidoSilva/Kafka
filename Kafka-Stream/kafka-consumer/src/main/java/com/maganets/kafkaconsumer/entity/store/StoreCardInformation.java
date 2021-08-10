package com.maganets.kafkaconsumer.entity.store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maganets.kafkaconsumer.utils.EncryptionUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StoreCardInformation implements Serializable {

  private String number;
  private String holder;
  private String validityMonth;
  private String validityYear;
  private String safety;
  private String flag;
  private Integer installmentsNumber;
  private BigDecimal value;
  private String token;
  private String tokenCreditCard;
  private String paymentToken;
  private Integer optIn;
  private StoreElectronicWallet electronicWallet;
  private String bin;
  private String lastFourDigits;

  public boolean isNCard() {
    return ObjectUtils.defaultIfNull(this.flag, StringUtils.EMPTY).contains("NCARD");
  }

  @JsonIgnore
  public String getDecryptNumber() {
    return EncryptionUtils.decrypt(this.number);
  }

  @JsonIgnore
  public String getDecryptSafety() {
    return EncryptionUtils.decrypt(this.safety);
  }

  @JsonIgnore
  public String getDecryptValidityMonth() {
    return EncryptionUtils.decrypt(this.validityMonth);
  }

  @JsonIgnore
  public String getDecryptValidityYear() {
    return EncryptionUtils.decrypt(this.validityYear);
  }
}
