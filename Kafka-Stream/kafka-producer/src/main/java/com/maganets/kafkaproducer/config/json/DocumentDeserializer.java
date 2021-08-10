package com.maganets.kafkaproducer.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

import static com.maganets.kafkaproducer.utils.NormalizeDocumentUtil.normalizeDocument;

public class DocumentDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException {
    return normalizeDocument(jsonparser.getText());
  }
}
