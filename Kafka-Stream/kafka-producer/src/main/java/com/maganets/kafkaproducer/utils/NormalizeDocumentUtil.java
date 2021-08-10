package com.maganets.kafkaproducer.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NormalizeDocumentUtil {

  public static String normalizeDocument(final String document) {
    long documentNumber = Long.parseLong(document.replaceAll("[^0-9]", ""));
    return String.format("%014d", documentNumber);
  }
}
