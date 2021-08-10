package com.maganets.kafkaconsumer.entity.krecord;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KOrder {

  private String ORDERNUMBER;
  private String CATALOGCODE;
  private String SALEDATE;
  private KOrderStatus STATUS;
  private String CUSTOMERCODE;
  private String CUSTOMEREMAIL;
  private String CUSTOMERCNPJ;
  private Double SUBTOTAL;
  private Double DISCOUNTVALUE;
  private Double BILLETDISCOUNTVALUE;
  private Double OTHERDISCOUNTVALUE;
  private Double TOTALORDERVALUE;
}
