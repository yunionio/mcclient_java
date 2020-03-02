package com.yunionyun.mcp.mcclient.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class CodecUtils {

  private static final int AES_BLOCK_SIZE = 16;

  /* private static void showBinary(byte[] bytes) {
  	System.out.print(bytes.length + ": ");
  	for(byte b: bytes) {
  		System.out.print(b);
  		System.out.print(" ");
  	}
  	System.out.println();
  }*/

  public static void disableHttpsVerification() {
    X509TrustManager tm =
            new X509TrustManager() {

              public void checkClientTrusted(X509Certificate[] chain, String authType)
                      throws CertificateException {
              }

              public void checkServerTrusted(X509Certificate[] chain, String authType)
                      throws CertificateException {
              }

              public X509Certificate[] getAcceptedIssuers() {
                return null;
              }
        };

    TrustManager[] trustAllCerts = new TrustManager[]{tm};

    try {
      SSLContext sc = SSLContext.getInstance("SSL");
      sc.init(null, trustAllCerts, new java.security.SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (Exception e) {
      e.printStackTrace();
    }

    HostnameVerifier allHostsValid =
            new HostnameVerifier() {
              public boolean verify(String hostname, SSLSession session) {
                return true;
              }
        };

    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
  }

  private static Key toAESKey(String key) throws UnsupportedEncodingException {
    byte[] keyBytes = new byte[32];
    byte[] obytes = key.getBytes("UTF-8");
    for (int i = 0; i < keyBytes.length; i++) {
      if (i < obytes.length) {
        keyBytes[i] = obytes[i];
      } else {
        keyBytes[i] = '$';
      }
    }
    return new SecretKeySpec(keyBytes, "AES");
  }

  public static String decryptAESBase64(String secret, String key)
          throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
          IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
          UnsupportedEncodingException {
    byte[] decSecret = Base64.getDecoder().decode(secret.getBytes("UTF-8"));
    IvParameterSpec ivSpec = new IvParameterSpec(decSecret, 0, AES_BLOCK_SIZE);
    Key aesKey = toAESKey(key);
    Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
    cipher.init(Cipher.DECRYPT_MODE, aesKey, ivSpec);
    byte[] decodedBytes =
            cipher.doFinal(decSecret, AES_BLOCK_SIZE, decSecret.length - AES_BLOCK_SIZE);
    return new String(decodedBytes);
  }

  public static String camelSplit(String camel) {
    String regex = "([a-z])([A-Z]+)";
    String replacement = "$1_$2";
    return camel.replaceAll(regex, replacement).toLowerCase();
  }

  public static List<String> loadLines(String fn) throws FileNotFoundException {
    Scanner inFile1 = new Scanner(new File(fn));
    inFile1.useDelimiter("\n");
    List<String> temps = new ArrayList<String>();
    while (inFile1.hasNext()) {
      temps.add(inFile1.next());
    }
    inFile1.close();
    return temps;
  }
}
