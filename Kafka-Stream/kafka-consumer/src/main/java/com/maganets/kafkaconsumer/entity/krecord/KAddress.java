package com.maganets.kafkaconsumer.entity.krecord;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KAddress {
  private String NAME;
  private String LASTNAME;
  private String COUNTRY;
  private String STATE;
  private String CITY;
  private String STREET;
  private String NUMBER;
  private String ADDITIONALINFO;
  private String NEIGHBORHOOD;
  private String ZIPCODE;
  private String REFERENCEPOINT;
  private String DESCRIPTION;
  private Boolean BUSINESSADDRESS;
  private String FULLNAME;
}
