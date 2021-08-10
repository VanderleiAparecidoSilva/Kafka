package com.maganets.kafkaconsumer.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

public class EncryptionUtils {

  private static final String KEY = "toxeklw666ofih9*";
  private static final String SALT = "#THXykyzabup*@lq";
  private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  private static final String ALGORITHM = "AES";
  private static final String ENCRYPT_PREFIX = "PROXY_";

  public static String decrypt(final String hash) {
    try {
      if (isEmpty(hash)) {
        return StringUtils.EMPTY;
      }

      final Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(
          Cipher.DECRYPT_MODE,
          new SecretKeySpec(KEY.getBytes(), ALGORITHM),
          new IvParameterSpec(SALT.getBytes()));
      return new String(cipher.doFinal(Base64.decodeBase64(hash.getBytes())), "UTF-8");
    } catch (final NoSuchAlgorithmException
        | NoSuchPaddingException
        | InvalidKeyException
        | UnsupportedEncodingException
        | BadPaddingException
        | IllegalBlockSizeException
        | InvalidAlgorithmParameterException e) {
      throw new RuntimeException(e);
    }
  }

  public static String removeEncryptPrefix(final String hash) {
    return Optional.ofNullable(hash)
        .map(
            newHash ->
                newHash.contains(ENCRYPT_PREFIX)
                    ? newHash.substring(ENCRYPT_PREFIX.length())
                    : hash)
        .orElse(hash);
  }
}
