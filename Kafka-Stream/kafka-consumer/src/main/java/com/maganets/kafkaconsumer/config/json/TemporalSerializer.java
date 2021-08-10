package com.maganets.kafkaconsumer.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.temporal.Temporal;

public class TemporalSerializer extends JsonSerializer<Temporal> {
  @Override
  public void serialize(
      Temporal temporal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    if (temporal == null) {
      jsonGenerator.writeNull();
    } else {
      jsonGenerator.writeString(temporal.toString());
    }
  }
}
