package com.yyq.holiday.common.util;

import org.apache.http.conn.ssl.SSLSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * SSL Socket工厂类
 */
public class YTSSLSocketFactory extends SSLSocketFactory {

	private SSLContext sslContext = SSLContext.getInstance(TLS);

	/**
	 * 构造SSLSocketFactory
	 * @param truststore：证书库
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 */
	@SuppressWarnings("deprecation")
	public YTSSLSocketFactory(KeyStore truststore)
			throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
		super(truststore);
		TrustManager tm = new X509TrustManager() {

			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		this.sslContext.init(null, new TrustManager[] { tm }, null);
		this.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); // 允许所有主机的验证
	}

	/**
	 * 创建Socket
	 */
	public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
			throws IOException, UnknownHostException {
		socket = this.sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
		return socket;
	}

	/**
	 * 创建Socket
	 */
	public Socket createSocket() throws IOException {
		Socket socket = this.sslContext.getSocketFactory().createSocket();
		return socket;
	}
}