package com.maganets.kafkaconsumer.entity.store;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maganets.kafkaconsumer.config.json.DocumentDeserializer;
import com.maganets.kafkaconsumer.config.json.LocalDateDeserializer;
import com.maganets.kafkaconsumer.config.json.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class StoreCustomer implements Serializable {

  private String catalog;
  private Long externalCode;

  @NotBlank(message = "O CAMPO NOME NÃO DEVE SER NULO OU VAZIO")
  private String name;

  private String lastName;
  private String email;
  private boolean htmlEmail;
  private boolean wishReceiveSms;
  private boolean individualPerson;
  private String storeId;

  @JsonDeserialize(using = DocumentDeserializer.class)
  @NotBlank(message = "O CAMPO CPFCNPJ NÃO DEVE SER NULO OU VAZIO")
  private String cpfCnpj;

  private String stateInscription;

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate birthDate;

  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private String gender;
  private String phoneDDD;
  private String phoneNumber;
  private String mobileDDD;
  private String mobileNumber;
  private boolean wishReceiveEmail;
  private StoreAddress deliveryAddress;
  private StoreAddress billingAddress;
  private LocalDateTime lastUpdate;
  private String profileStatus;

  public String getCustomerId() {
    return this.storeId.concat("-").concat(this.cpfCnpj);
  }

  public String getFullName() {
    return this.name.concat(
        StringUtils.isEmpty(this.lastName) ? StringUtils.EMPTY : " ".concat(this.lastName.trim()));
  }

  public Integer getTelephoneDDD() {
    return !StringUtils.isEmpty(this.phoneDDD) ? Integer.parseInt(this.phoneDDD) : null;
  }

  public Integer getCellphoneDDD() {
    return !StringUtils.isEmpty(this.mobileDDD) ? Integer.parseInt(this.mobileDDD) : null;
  }

  public String getTelephoneNumber() {
    return !StringUtils.isEmpty(this.phoneNumber)
        ? this.phoneNumber.length() <= 15 ? this.phoneNumber : this.phoneNumber.substring(0, 15)
        : null;
  }

  public String getCellphoneNumber() {
    return !StringUtils.isEmpty(this.mobileNumber)
        ? this.mobileNumber.length() <= 15 ? this.mobileNumber : this.mobileNumber.substring(0, 15)
        : null;
  }
}
