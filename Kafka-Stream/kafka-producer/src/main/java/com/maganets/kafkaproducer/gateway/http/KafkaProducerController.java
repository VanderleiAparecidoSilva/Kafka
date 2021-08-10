package com.maganets.kafkaproducer.gateway.http;

import com.maganets.kafkaproducer.entity.store.StoreOrderWrapper;
import com.maganets.kafkaproducer.service.FreedomStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KafkaProducerController {

  private final FreedomStoreService freedomStoreService;

  @PostMapping(
      value = "/freedom/store",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createAndPublishFreedomStore(
      @RequestBody final StoreOrderWrapper storeOrderWrapper) {
    freedomStoreService.createFreedomStore(storeOrderWrapper);
    return ResponseEntity.accepted().build();
  }
}
