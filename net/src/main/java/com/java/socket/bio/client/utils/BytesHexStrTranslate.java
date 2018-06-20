package com.java.socket.bio.client.utils;

import java.util.Arrays;

public class BytesHexStrTranslate {

	private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * 方法一： byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun1(byte[] bytes) {
		// 一个byte为8位，可用两个十六进制位标识
		char[] buf = new char[bytes.length * 2];
		int a = 0;
		int index = 0;
		for (byte b : bytes) { // 使用除与取余进行转换
			if (b < 0) {
				a = 256 + b;
			} else {
				a = b;
			}

			buf[index++] = HEX_CHAR[a / 16];
			buf[index++] = HEX_CHAR[a % 16];
		}

		return new String(buf);
	}

	/**
	 * 方法二： byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun2(byte[] bytes) {
		char[] buf = new char[bytes.length * 2];
		int index = 0;
		for (byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
			buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
			buf[index++] = HEX_CHAR[b & 0xf];
		}

		return new String(buf);
	}

	/**
	 * 方法三： byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun3(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) { // 使用String的format方法进行转换
			buf.append(String.format("%02x", new Integer(b & 0xff)));
		}

		return buf.toString();
	}

	/**
	 * 将16进制字符串转换为byte[]
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] toBytes(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}

		return bytes;
	}

	public static void main(String[] args) throws Exception {
		// byte[] bytes = "刘杰".getBytes("utf-8");
		// System.out.println("字节数组为：" + Arrays.toString(bytes));
		// System.out.println("方法一：" + bytesToHexFun1(bytes));
		// System.out.println("方法二：" + bytesToHexFun2(bytes));
		// System.out.println("方法三：" + bytesToHexFun3(bytes));
		//
		// System.out.println("==================================");
		//
		// String str = "e58898e69db0";
		// System.out.println("转换后的字节数组：" + Arrays.toString(toBytes(str)));
		// System.out.println(new String(toBytes(str), "utf-8"));

//		// 字符转byte
//		byte y = hexToByte("20");
//
//		System.out.println(Integer.parseUnsignedInt("20", 16));
//		System.out.println(y);
//
//		// 数字转十六进制字符
//		System.out.println("数字转十六进制字符："+toHex(128).replaceAll("^(0+)", ""));
//
//		//int转byte  byte转int
//		byte[] ts = IntToByteArray(128);
//		System.out.println(Arrays.toString(ts));
//		System.out.println(ByteArrayToInt(ts));
//		
//		
//		System.err.println(Arrays.toString(ts));
//		System.out.println("字节数组："+SocketUtil.BinaryToHexString(ts));
//		
//		
//		String name="arison";
//		String type="0001";
//		int num=20;
//		
//		byte a=ByteUtil.intToByte(num);
//		System.out.println("数字128："+a);
//		System.out.println(ByteUtil.hexStringToInt(type));;
//		
		
		  BytesHexStrTranslate strToHex = new BytesHexStrTranslate();
		  System.out.println("\n-----ASCII码转换为16进制 -----");
		 // String str = "POS88884"; 
		  
		  //在String中，一个英文字符占1个字节
		  String str = "20name"; //六个字符，十二个字节
		  
		  System.out.println("字符串: " + str);
		  System.out.println("字节码："+Arrays.toString(SocketUtil.strToByteArray(str)));
		  System.out.println("字节码长度："+SocketUtil.strToByteArray(str).length);
		  String hex = strToHex.convertStringToHex(str);
		  System.out.println("转换为16进制 : " + hex);
		  System.out.println("转换为16进制 : " + SocketUtil.BinaryToHexString(SocketUtil.strToByteArray(str)));
	 
		  System.out.println("\n***** 16进制转换为ASCII *****");
		  System.out.println("Hex : " + hex);
		  System.out.println("ASCII : " + strToHex.convertHexToString(hex));
		  
		  
		   byte [] data=  SocketUtil.strToByteArray(str);
		   for(int i=0;i<data.length;i++){
			  System.out.println("data["+i+"]="+ byteToHex(data[i])+"=>"+data[i]);
		   }
		   
		   //数值类型转十六进制
		   //一个int占用4个字节码
		   //一个字符占用2个字节
		   int num=340;
		   byte bt=ByteUtil.intToByte(num);
		   byte [] bts=ByteUtil.intToByteArray(num);
		   System.out.println("999的十六进制："+byteToHex(bt));
		   System.out.println("999 字节码："+Arrays.toString(bts));
		   System.out.println("999 十六进制字符串："+SocketUtil.BinaryToHexString(bts));
		   
	
		   
		
	
		   byte [] datas1={14,48,110,97,109,101};	   
		   System.out.println(Arrays.toString(datas1));
		   System.out.println(SocketUtil.BinaryToHexString(datas1));
	}
	
	
	

	public static byte[] IntToByteArray(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

	public static int ByteArrayToInt(byte[] bArr) {
		if (bArr.length != 4) {
			return -1;
		}
		return (int) ((((bArr[3] & 0xff) << 24) | ((bArr[2] & 0xff) << 16)
				| ((bArr[1] & 0xff) << 8) | ((bArr[0] & 0xff) << 0)));
	}

	/**
	 * 字节转十六进制
	 *
	 * @param b
	 *            需要进行转换的byte字节
	 * @return 转换后的Hex字符串
	 */
	public static String byteToHex(byte b) {
		String hex = Integer.toHexString(b & 0xFF);
		if (hex.length() < 2) {
			hex = "0" + hex;
		}
		return hex;
	}

	/**
	 * Hex字符串转byte
	 * 
	 * @param inHex
	 *            待转换的Hex字符串
	 * @return 转换后的byte
	 */
	public static byte hexToByte(String inHex) {

		return (byte) Integer.parseUnsignedInt(inHex, 16);
	}

	private static final char[] DIGITS_HEX = {'0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	protected static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS_HEX[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_HEX[0x0F & data[i]];
		}
		return out;
	}

	protected static byte[] decodeHex(char[] data) {
		int len = data.length;
		if ((len & 0x01) != 0) {
			throw new RuntimeException("字符个数应该为偶数");
		}
		byte[] out = new byte[len >> 1];
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f |= toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}
		return out;
	}

	protected static int toDigit(char ch, int index) {
		int digit = Character.digit(ch, 16);
		if (digit == -1) {
			throw new RuntimeException("Illegal hexadecimal character " + ch
					+ " at index " + index);
		}
		return digit;
	}

	public static String toHex(String str) {
		return new String(encodeHex(str.getBytes()));
	}

	public static String fromHex(String hex) {
		return new String(decodeHex(hex.toCharArray()));
	}

	public static String toHex(int num) {
		char[] chs = new char[8];// 定义容器，存储的是字符，长度为8.一个整数最多8个16进制数
		int index = chs.length - 1;
		for (int i = 0; i < 8; i++) {
			int temp = num & 15;

			if (temp > 9) {
				chs[index] = ((char) (temp - 10 + 'A'));
			} else {
				chs[index] = ((char) (temp + '0'));
			}

			index--;
			num = num >>> 4;
		}
		return toString(chs);
	}
	// 将数组转为字符串
	public static String toString(char[] arr) {
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			temp = temp + arr[i];
		}
		return temp;
	}
	
	
	 public String convertStringToHex(String str){
		 
		  char[] chars = str.toCharArray();
	 
		  StringBuffer hex = new StringBuffer();
		  for(int i = 0; i < chars.length; i++){
		    hex.append(Integer.toHexString((int)chars[i]));
		  }
	 
		  return hex.toString();
		  }
	 
		  public String convertHexToString(String hex){
	 
		  StringBuilder sb = new StringBuilder();
		  StringBuilder temp = new StringBuilder();
	 
		  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
		  for( int i=0; i<hex.length()-1; i+=2 ){
	 
		      //grab the hex in pairs
		      String output = hex.substring(i, (i + 2));
		      //convert hex to decimal
		      int decimal = Integer.parseInt(output, 16);
		      //convert the decimal to character
		      sb.append((char)decimal);
	 
		      temp.append(decimal);
		  }
	 
		  return sb.toString();
		  }

}
