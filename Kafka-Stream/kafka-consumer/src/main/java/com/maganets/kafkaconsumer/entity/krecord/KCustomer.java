package com.maganets.kafkaconsumer.entity.krecord;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class KCustomer {

  private String CATALOG;
  private String EXTERNALCODE;
  private String NAME;
  private String LASTNAME;
  private String EMAIL;
  private Boolean HTMLEMAIL;
  private Boolean WISHRECEIVESMS;
  private String INDIVISUALPERSON;
  private String STOREID;
  private String CPFCNPJ;
  private String STATEINSCRIPTION;
  private LocalDate BIRTHDATE;
  private LocalDateTime CREATEDATE;
  private LocalDateTime UPDATEDATE;
  private String GENDER;
  private String PHONEDDD;
  private String PHONENUMBER;
  private Boolean WISHRECEIVEEMAIL;
  private KAddress DELIVERYADDRESS;
  private KAddress BILLINGADDRESS;
  private LocalDate LASTUPDATE;
  private String PROFILESTATUS;
  private String FULLNAME;
  private String CUSTOMERID;
  private String TELEPHONEDDD;
  private String CELLPHONEDDD;
  private String TELEPHONENUMBER;
  private String CELLPHONENUMBER;
}
