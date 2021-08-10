package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class StoreAddress implements Serializable {

  private String name;
  private String lastName;
  private String country;
  private String state;
  private String city;

  @NotBlank(message = "O CAMPO LOGRADOURO NÃO DEVE SER NULO OU VAZIO")
  private String street;

  private String number;
  private String additionalInfo;
  private String neighborhood;
  private String zipCode;
  private String referencePoint;
  private String description;
  private boolean businessAddress;
  private String postOfficeName;

  public String getFullName() {
    return this.name
        .trim()
        .concat(
            StringUtils.isBlank(this.lastName)
                ? StringUtils.EMPTY
                : " ".concat(this.lastName.trim()));
  }
}
