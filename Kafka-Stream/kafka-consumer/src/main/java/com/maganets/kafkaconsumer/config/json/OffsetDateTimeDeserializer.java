package com.maganets.kafkaconsumer.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;

public class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

  @Override
  public OffsetDateTime deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

    String date = jsonParser.getText();
    return OffsetDateTime.parse(date);
  }
}
