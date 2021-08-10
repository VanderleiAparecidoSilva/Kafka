package com.maganets.kafkaconsumer.config.json;

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
  public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException {

    /*
      Deserialize the attribute to LocalDateTime

      Check if the attribute is in milliseconds or LocalDateTime to deserialize correctly
    */
    String date = jsonparser.getText();
    if (StringUtils.isNumeric(date)) {
      Long dateInMillis = Long.valueOf(date);
      Instant instant = Instant.ofEpochMilli(dateInMillis);
      return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    } else {
      return LocalDateTime.parse(date);
    }
  }
}
