package com.maganets.kafkaproducer.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_PATTERN);

  @Override
  public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    String formattedDate = dateFormat.format(date);
    gen.writeString(formattedDate);
  }
}
