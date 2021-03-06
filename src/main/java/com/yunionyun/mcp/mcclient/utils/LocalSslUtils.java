package com.yunionyun.mcp.mcclient.utils;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class LocalSslUtils {
	public LocalSslUtils() {
	}

	private static void trustAllHttpsCertificates()
			throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	public static void ignoreSsl() throws KeyManagementException, NoSuchAlgorithmException {
		HostnameVerifier hv =
				new HostnameVerifier() {
					public boolean verify(String urlHostName, SSLSession session) {
						System.out.println(
								"Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
						return true;
					}
				};
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

	static class miTM implements TrustManager, javax.net.ssl.X509TrustManager {
		miTM() {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
		}

		public void checkClientTrusted(X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
		}
	}
}
