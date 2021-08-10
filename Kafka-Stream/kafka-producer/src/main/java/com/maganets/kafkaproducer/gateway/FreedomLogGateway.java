package com.maganets.kafkaproducer.gateway;

import com.maganets.kafkaproducer.entity.log.LogStoreWrapper;
import com.maganets.kafkaproducer.entity.store.StoreOrderWrapper;

public interface FreedomLogGateway {

  LogStoreWrapper saveStoreWrapper(final StoreOrderWrapper storeOrderWrapper);
}
