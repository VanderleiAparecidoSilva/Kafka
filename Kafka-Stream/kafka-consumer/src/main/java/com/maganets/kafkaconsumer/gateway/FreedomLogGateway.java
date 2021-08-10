package com.maganets.kafkaconsumer.gateway;

import com.maganets.kafkaconsumer.entity.krecord.KRecord;
import com.maganets.kafkaconsumer.entity.log.LogNetsStore;
import com.maganets.kafkaconsumer.entity.log.LogZattStore;
import com.maganets.kafkaconsumer.entity.store.StoreOrderWrapper;

public interface FreedomLogGateway {

  LogNetsStore saveNetsStore(final KRecord record);

  LogZattStore saveZattStore(final StoreOrderWrapper wrapper);
}
