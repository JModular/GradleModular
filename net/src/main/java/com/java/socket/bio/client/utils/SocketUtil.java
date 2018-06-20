package com.java.socket.bio.client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class SocketUtil {
	private static final String TAG = SocketUtil.class.getSimpleName();
	public static String ADDRESS = "192.168.253.200";
	public static int PORT = 10086;

	public static final int SUCCESS = 100;
	public static final int FAILED = -1;

	/**
	 * 读数据
	 *
	 * @param bufferedReader
	 */
	public static String readFromStream(BufferedReader bufferedReader) {
		try {
			String s;
			if ((s = bufferedReader.readLine()) != null) {
				return s;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 写数据
	 *
	 * @param data
	 * @param printWriter
	 */
	public static void write2Stream(String data, PrintWriter printWriter) {
		if (data == null) {
			return;
		}
		if (printWriter != null) {
			printWriter.println(data);
		}
	}

	/**
	 * 关闭输入流
	 *
	 * @param socket
	 */
	public static void inputStreamShutdown(Socket socket) {
		try {
			if (!socket.isClosed() && !socket.isInputShutdown()) {
				socket.shutdownInput();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭输入流
	 *
	 * @param br
	 */
	public static void closeBufferedReader(BufferedReader br) {
		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭输出流
	 *
	 * @param pw
	 */
	public static void closePrintWriter(PrintWriter pw) {
		if (pw != null) {
			pw.close();
		}
	}

	/**
	 * 阻塞线程,millis为0则永久阻塞,知道调用notify()
	 */
	public static void toWait(Object o, long millis) {
		synchronized (o) {
			try {
				o.wait(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后
	 *
	 * @param o
	 */
	public static void toNotifyAll(Object o) {
		synchronized (o) {
			o.notifyAll();
		}
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		// toUpperCase将字符串中的所有字符转换为大写
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		// toCharArray将此字符串转换为一个新的字符数组。
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4
					| charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	// charToByte返回在指定字符的第一个发生的字符串中的索引，即返回匹配字符
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	// 将字节数组转换为short类型，即统计字符串长度
	public static short bytes2Short2(byte[] b) {
		short i = (short) (((b[1] & 0xff) << 8) | b[0] & 0xff);
		return i;
	}
	// 将字节数组转换为16进制字符串
	public static String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (byte b : bytes) {
			hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
			hex += String.valueOf(hexStr.charAt(b & 0x0F));
			result += hex + "";
		}
		return result;
	}

	
	
	
	/**
	 * @param str
	 * @return
	 */
	public static byte[] strToByteArray(String str) {
	    if (str == null) {
	        return null;
	    }
	    byte[] byteArray = str.getBytes();
	    return byteArray;
	}


	
	/**
	 * @param byteArray
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String byteArrayToStr(byte[] byteArray) throws UnsupportedEncodingException {
	    if (byteArray == null) {
	        return null;
	    }
	    String str = new String(byteArray,"");
	    return str;
	}
	
	
	
	/**
	 * 字节数组转十六进制字符串
	 * @param byteArray
	 * @return
	 */
	public static String byteArrayToHexStr(byte[] byteArray) {
	    if (byteArray == null){
	        return null;
	    }
	    char[] hexArray = "0123456789ABCDEF".toCharArray();
	    char[] hexChars = new char[byteArray.length * 2];
	    for (int j = 0; j < byteArray.length; j++) {
	        int v = byteArray[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}





}
