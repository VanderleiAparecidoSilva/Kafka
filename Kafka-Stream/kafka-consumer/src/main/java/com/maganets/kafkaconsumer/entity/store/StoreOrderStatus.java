package com.maganets.kafkaconsumer.entity.store;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderStatus implements Serializable {

  private String value;
}
