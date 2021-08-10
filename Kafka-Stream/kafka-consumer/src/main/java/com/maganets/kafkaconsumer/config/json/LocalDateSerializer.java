package com.maganets.kafkaconsumer.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

  public static final String DATE_PATTERN = "yyyy-MM-dd";

  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_PATTERN);

  @Override
  public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    String formattedDate = dateFormat.format(date);
    gen.writeString(formattedDate);
  }
}
