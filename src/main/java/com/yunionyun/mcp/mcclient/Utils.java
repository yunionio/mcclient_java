package com.yunionyun.mcp.mcclient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunionyun.mcp.mcclient.utils.LoggerUtils;

import sun.net.www.protocol.https.HttpsURLConnectionImpl;


public class Utils {
    private static Logger logger = LoggerUtils.createLoggerFor(Utils.class.getName());
	
	private static Pattern duration_pattern = Pattern.compile("^\\d+[HhMm]$");
	public static boolean matchDuration(String dura) {
		Matcher matcher = duration_pattern.matcher(dura);
		return matcher.find();
	}
	
	public static void disableHttpsVerification() {
		X509TrustManager tm = new X509TrustManager() {
			
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

		TrustManager[] trustAllCerts = new TrustManager[] {tm};

		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}
	
	private static final JSONObject empty = new JSONObject();
	public static JSONObject getJSONResult(JSONObject data, String field) {
		if (data.size() == 0 || !data.containsKey(field) || !(data.get(field) instanceof JSONObject)) {
			return empty;
		}else {
			return data.getJSONObject(field);
		}
	}
	
	public static JSONArray stringArray2JSONArray(String[] array) {
		JSONArray ret = new JSONArray();
		for(String str: array) {
			ret.add(str);
		}
		return ret;
	}
	
	private static String decrypt(Key decryptionKey, byte[] buffer) {
	    try {
	        Cipher rsa = Cipher.getInstance("RSA");
	        rsa.init(Cipher.DECRYPT_MODE, decryptionKey);
	        byte[] utf8 = rsa.doFinal(buffer);
	        return new String(utf8, "UTF8");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	private static KeyPair readKeyPair(String keyPath, String keyPassword) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(keyPath));
		Security.addProvider(new BouncyCastleProvider());
		PEMParser pp = new PEMParser(br);
		PEMKeyPair pemKeyPair = (PEMKeyPair) pp.readObject();
		KeyPair kp = new JcaPEMKeyConverter().getKeyPair(pemKeyPair);
		pp.close();
		return kp;
	}
	
	public static String decrypt_password(String keyfile, String keypass, String data) throws IOException {
		KeyPair kp = readKeyPair(keyfile, keypass);
		byte[] secret = data.getBytes();
		return decrypt(kp.getPrivate(), secret);
 	}
	
	public static void JSONAdd(JSONObject body, Object obj, String...keys) {
		JSONObject current = body;
		for(int i = 0; i < keys.length; i ++) {
			String key = keys[i];
			if (i < keys.length - 1) {
				JSONObject target = null;
				if (current.containsKey(key)) {
					target = current.getJSONObject(key);
				} else {
					target = new JSONObject();
					current.put(key, target);
				}
				current = target;
			}else {
				current.put(key, obj);
			}
		}
	}
	
	public static Date string2Date(String str) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
		Date date = format.parse(str);
		return date;
	}
	
	public static String[] SplitVersionedURL(String url) {
	    int endidx = url.length() - 1;
	    while (url.charAt(endidx) == '/') {
	    		endidx --;
	    }
	    int lastSlash = url.lastIndexOf('/', endidx);
	    if (lastSlash >= 0) {
	    	    String baseUrl = url.substring(0, lastSlash);
	    		String verStr = url.substring(lastSlash+1, endidx);
	    		if (verStr.toLowerCase().equals("latest")) {
	    			return new String[] {baseUrl, null};
	    		}
	    		if (Pattern.matches("^v\\d+\\.?\\d*", verStr)) {
	    			return new String[] {baseUrl, verStr};
	    		}
	    }
	    return new String[] {url.substring(0, endidx+1), null};
	}

	public static String stripURLVersion(String url) {
		String[] splitUrl = SplitVersionedURL(url);
		return splitUrl[0];
	}

	public static String JSONObject2QueryString(JSONObject obj) {
		try{ 
			return _JSONObject2QueryString(obj);
		}catch (Exception e) {
		    logger.error("", e);
		}
		return "";
	}
	
	private static String _JSONObject2QueryString(JSONObject obj) throws UnsupportedEncodingException  {
		StringBuilder queryBuilder = new StringBuilder();
		for (String key: obj.keySet()) {
			Object valObj = obj.get(key);
			if(valObj instanceof JSONArray) {//如果是JSONArray的情况@added by zhengjiajie@20180418
				JSONArray dataArray = (JSONArray)valObj;
				for(int idx=0; idx<dataArray.size(); idx++) {
					String val = (String)dataArray.get(idx);
					addKeyValueToStringBuilder(queryBuilder, key, val);
				}
			} else {//不是JSONArray的情况,按照原有的逻辑进行处理
				String val = obj.getString(key);
				addKeyValueToStringBuilder(queryBuilder, key, val);
			}
		}
		return queryBuilder.toString();
	}

	/**
	 * 把key和val添加到queryBuilder中
	 * @param queryBuilder
	 * @param key
	 * @param val
	 * @throws UnsupportedEncodingException
	 */
	private static void addKeyValueToStringBuilder(StringBuilder queryBuilder, String key, String val)
			throws UnsupportedEncodingException {
		if (queryBuilder.length() > 0) {
			queryBuilder.append("&");
		}
		queryBuilder.append(URLEncoder.encode(key, "UTF-8"));
		queryBuilder.append("=");
		queryBuilder.append(URLEncoder.encode(val, "UTF-8"));
	}
	
	
	
	public static int bitLength(long num) {
		int bitlen = 0;
		while ((num >> bitlen) > 0) {
			bitlen += 1;
		}
		return bitlen;
	}
	
	private static long bytes2int(byte[] bytes, int offset) {
		long val = 0;
		for(int i = offset; i < offset + 4 && i < bytes.length; i ++) {
		    long tmp = ((long)bytes[i] & 0xffL);
			val |= ((tmp << ((3 - i)*8)) & 0xffffffffL);
		}
		return val;
	}
	
	public static long hash(String text, String alg) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(alg);
			messageDigest.update(text.getBytes());
			byte byteBuffer[] = messageDigest.digest();
			long ret = 0;
			for (int i = 0; i < byteBuffer.length; i += 4) {
				ret |= bytes2int(byteBuffer, i);
			}
			return ret;
		}catch (Exception e) {
		    logger.error("Hash error: " + e);
			return -1;
		}
	}
	
	public static void setHttpRequestMethod(final HttpURLConnection c, final String value) {
	    try {
	        final Object target;
	        if (c instanceof HttpsURLConnectionImpl) {
	            final Field delegate = HttpsURLConnectionImpl.class.getDeclaredField("delegate");
	            delegate.setAccessible(true);
	            target = delegate.get(c);
	        } else {
	            target = c;
	        }
	        final Field f = HttpURLConnection.class.getDeclaredField("method");
	        f.setAccessible(true);
	        f.set(target, value);
	    } catch (IllegalAccessException ex) {
	        throw new AssertionError(ex);
	    } catch (NoSuchFieldException ex) {
	    		throw new AssertionError(ex);
	    }
	}
}
