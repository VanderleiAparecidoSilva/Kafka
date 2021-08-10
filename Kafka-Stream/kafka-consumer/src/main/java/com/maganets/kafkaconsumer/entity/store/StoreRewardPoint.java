package com.maganets.kafkaconsumer.entity.store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class StoreRewardPoint implements Serializable {

  private String name;
  private Long points;
}
