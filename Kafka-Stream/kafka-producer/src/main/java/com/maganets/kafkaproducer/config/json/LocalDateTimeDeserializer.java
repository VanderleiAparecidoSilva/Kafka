package com.maganets.kafkaproducer.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  @Override
  public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext context)
      throws IOException {
    String date = jsonParser.getText();
    if (StringUtils.isNumeric(date)) {
      Long dateInMillis = Long.valueOf(date);
      Instant instant = Instant.ofEpochMilli(dateInMillis);
      return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    } else {
      return LocalDateTime.parse(date);
    }
  }
}
