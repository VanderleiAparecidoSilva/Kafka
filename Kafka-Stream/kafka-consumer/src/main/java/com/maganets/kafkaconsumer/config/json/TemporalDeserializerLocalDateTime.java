package com.maganets.kafkaconsumer.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class TemporalDeserializerLocalDateTime extends JsonDeserializer<Temporal> {

  @Override
  public Temporal deserialize(JsonParser jsonParser, DeserializationContext deserializationCtx)
      throws IOException, JsonProcessingException {
    ObjectCodec oc = jsonParser.getCodec();
    String content = oc.readValue(jsonParser, String.class);

    if (content == null) {
      return null;
    }

    return LocalDateTime.parse(content);
  }
}
