package com.maganets.kafkaconsumer.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

  private static final DateTimeFormatter dateFormat =
      DateTimeFormatter.ofPattern(LocalDateSerializer.DATE_PATTERN);

  @Override
  public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException {
    String date = jsonparser.getText();
    return LocalDate.parse(date, dateFormat);
  }
}
