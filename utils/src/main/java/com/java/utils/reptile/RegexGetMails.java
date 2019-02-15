package com.java.utils.reptile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

@SuppressWarnings("unused")
public class RegexGetMails {

	public static void main(String[] args) throws Exception {
		List<String> list = getMailsByWeb();
		Set<String> set = new HashSet<String>(list);
		List<String> tempList = new ArrayList<String>(set);
		for (String mail : tempList) {
			System.out.println(mail);
		}

	}

	public static List<String> getMailsByWeb() throws Exception {
		String hostUrl = "https://www.zybuluo.com/Arison/note/1390294";
		// PrintWriter out = null;
		BufferedReader bufIn = null;
		HttpURLConnection conn = null;
		// String result = "";

		trustAllHttpsCertificates();
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {

				return true;
			}
		};
		// 使用HttpsURLConnection
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		conn = (HttpURLConnection) new URL(hostUrl).openConnection();
		// 发送GET请求必须设置如下两行
		conn.setDoInput(true);
		conn.setRequestMethod("GET");
		// // 发送POST请求必须设置如下两行
		// conn.setDoOutput(true);
		// conn.setDoInput(true);
		// 获取URLConnection对象对应的输出流
		// out = new PrintWriter(conn.getOutputStream());
		// 发送请求参数
		// out.print(params);
		// flush输出流的缓冲
		// out.flush();

		// flush输出流的缓冲
		bufIn = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));

		// URL url = new URL(hostUrl);
		// BufferedReader bufIn = new BufferedReader(
		// new InputStreamReader(url.openStream()));
		String mail_regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";//\\w+@\\w+(\\.\\w+)+
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				list.add(m.group());
			}
		}
		return list;
	}

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("SSL", "SunJSSE");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection
				.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	static class miTM
			implements
				javax.net.ssl.TrustManager,
				javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
}
