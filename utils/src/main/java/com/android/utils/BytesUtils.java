package com.android.utils;

import java.nio.charset.Charset;

import org.apache.commons.lang3.ArrayUtils;

/**
 * �ֽ�����ת��������
 */
public class BytesUtils {

	public static final String GBK = "GBK";
	public static final String UTF8 = "utf-8";
	public static final char[] ascii = "0123456789ABCDEF".toCharArray();
	private static char[] HEX_VOCABLE = {'0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	/**
	 * ��short������ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(short data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) ((data & 0xff00) >> 8);
		bytes[1] = (byte) (data & 0xff);
		return bytes;
	}

	/**
	 * ���ַ�ת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(char data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data >> 8);
		bytes[1] = (byte) (data);
		return bytes;
	}

	/**
	 * ������ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(boolean data) {
		byte[] bytes = new byte[1];
		bytes[0] = (byte) (data ? 1 : 0);
		return bytes;
	}

	/**
	 * ��������ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(int data) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) ((data & 0xff000000) >> 24);
		bytes[1] = (byte) ((data & 0xff0000) >> 16);
		bytes[2] = (byte) ((data & 0xff00) >> 8);
		bytes[3] = (byte) (data & 0xff);
		return bytes;
	}

	/**
	 * ��long������ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(long data) {
		byte[] bytes = new byte[8];
		bytes[0] = (byte) ((data >> 56) & 0xff);
		bytes[1] = (byte) ((data >> 48) & 0xff);
		bytes[2] = (byte) ((data >> 40) & 0xff);
		bytes[3] = (byte) ((data >> 32) & 0xff);
		bytes[4] = (byte) ((data >> 24) & 0xff);
		bytes[5] = (byte) ((data >> 16) & 0xff);
		bytes[6] = (byte) ((data >> 8) & 0xff);
		bytes[7] = (byte) (data & 0xff);
		return bytes;
	}

	/**
	 * ��float����ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(float data) {
		int intBits = Float.floatToIntBits(data);
		return getBytes(intBits);
	}

	/**
	 * ��double����ֵת��Ϊ�ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(double data) {
		long intBits = Double.doubleToLongBits(data);
		return getBytes(intBits);
	}

	/**
	 * ���ַ�������charsetName�����ʽ���ֽ�����
	 * 
	 * @param data
	 *            �ַ���
	 * @param charsetName
	 *            �����ʽ
	 * @return
	 */
	public static byte[] getBytes(String data, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return data.getBytes(charset);
	}

	/**
	 * ���ַ�������GBK�����ʽ���ֽ�����
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(String data) {
		return getBytes(data, GBK);
	}

	/**
	 * ���ֽ������0�ֽ�ת��Ϊ����ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static boolean getBoolean(byte[] bytes) {
		return bytes[0] == 1;
	}

	/**
	 * ���ֽ�����ĵ�index�ֽ�ת��Ϊ����ֵ
	 * 
	 * @param bytes
	 * @param index
	 * @return
	 */
	public static boolean getBoolean(byte[] bytes, int index) {
		return bytes[index] == 1;
	}

	/**
	 * ���ֽ�����ǰ2�ֽ�ת��Ϊshort������ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static short getShort(byte[] bytes) {
		return (short) ((0xff00 & (bytes[0] << 8)) | (0xff & bytes[1]));
	}

	/**
	 * ���ֽ������startIndex��ʼ��2���ֽ�ת��Ϊshort������ֵ
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static short getShort(byte[] bytes, int startIndex) {
		return (short) ((0xff00 & (bytes[startIndex] << 8))
				| (0xff & bytes[startIndex + 1]));
	}

	/**
	 * ���ֽ�����ǰ2�ֽ�ת��Ϊ�ַ�
	 * 
	 * @param bytes
	 * @return
	 */
	public static char getChar(byte[] bytes) {
		return (char) ((0xff00 & (bytes[0] << 8)) | (0xff & bytes[1]));
	}

	/**
	 * ���ֽ������startIndex��ʼ��2���ֽ�ת��Ϊ�ַ�
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static char getChar(byte[] bytes, int startIndex) {
		return (char) ((0xff00 & (bytes[startIndex] << 8))
				| (0xff & bytes[startIndex + 1]));
	}

	/**
	 * ���ֽ�����ǰ4�ֽ�ת��Ϊ������ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getInt(byte[] bytes) {
		return (0xff000000 & (bytes[0] << 24) | (0xff0000 & (bytes[1] << 16))
				| (0xff00 & (bytes[2] << 8)) | (0xff & bytes[3]));
	}

	/**
	 * ���ֽ������startIndex��ʼ��4���ֽ�ת��Ϊ������ֵ
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static int getInt(byte[] bytes, int startIndex) {
		return (0xff000000 & (bytes[startIndex] << 24)
				| (0xff0000 & (bytes[startIndex + 1] << 16))
				| (0xff00 & (bytes[startIndex + 2] << 8))
				| (0xff & bytes[startIndex + 3]));
	}

	/**
	 * ���ֽ�����ǰ8�ֽ�ת��Ϊlong������ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static long getLong(byte[] bytes) {
		return (0xff00000000000000L & ((long) bytes[0] << 56)
				| (0xff000000000000L & ((long) bytes[1] << 48))
				| (0xff0000000000L & ((long) bytes[2] << 40))
				| (0xff00000000L & ((long) bytes[3] << 32))
				| (0xff000000L & ((long) bytes[4] << 24))
				| (0xff0000L & ((long) bytes[5] << 16))
				| (0xff00L & ((long) bytes[6] << 8))
				| (0xffL & (long) bytes[7]));
	}

	/**
	 * ���ֽ������startIndex��ʼ��8���ֽ�ת��Ϊlong������ֵ
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static long getLong(byte[] bytes, int startIndex) {
		return (0xff00000000000000L & ((long) bytes[startIndex] << 56)
				| (0xff000000000000L & ((long) bytes[startIndex + 1] << 48))
				| (0xff0000000000L & ((long) bytes[startIndex + 2] << 40))
				| (0xff00000000L & ((long) bytes[startIndex + 3] << 32))
				| (0xff000000L & ((long) bytes[startIndex + 4] << 24))
				| (0xff0000L & ((long) bytes[startIndex + 5] << 16))
				| (0xff00L & ((long) bytes[startIndex + 6] << 8))
				| (0xffL & (long) bytes[startIndex + 7]));
	}

	/**
	 * ���ֽ�����ǰ4�ֽ�ת��Ϊfloat����ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static float getFloat(byte[] bytes) {
		return Float.intBitsToFloat(getInt(bytes));
	}

	/**
	 * ���ֽ������startIndex��ʼ��4���ֽ�ת��Ϊfloat����ֵ
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static float getFloat(byte[] bytes, int startIndex) {
		byte[] result = new byte[4];
		System.arraycopy(bytes, startIndex, result, 0, 4);
		return Float.intBitsToFloat(getInt(result));
	}

	/**
	 * ���ֽ�����ǰ8�ֽ�ת��Ϊdouble����ֵ
	 * 
	 * @param bytes
	 * @return
	 */
	public static double getDouble(byte[] bytes) {
		long l = getLong(bytes);
		return Double.longBitsToDouble(l);
	}

	/**
	 * ���ֽ������startIndex��ʼ��8���ֽ�ת��Ϊdouble����ֵ
	 * 
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public static double getDouble(byte[] bytes, int startIndex) {
		byte[] result = new byte[8];
		System.arraycopy(bytes, startIndex, result, 0, 8);
		long l = getLong(result);
		return Double.longBitsToDouble(l);
	}

	/**
	 * ��charsetName�����ʽ���ֽ�����ת��Ϊ�ַ���
	 * 
	 * @param bytes
	 * @param charsetName
	 * @return
	 */
	public static String getString(byte[] bytes, String charsetName) {
		return new String(bytes, Charset.forName(charsetName));
	}

	/**
	 * ��GBK�����ʽ���ֽ�����ת��Ϊ�ַ���
	 * 
	 * @param bytes
	 * @return
	 */
	public static String getString(byte[] bytes) {
		return getString(bytes, GBK);
	}

	/**
	 * ��16�����ַ���ת��Ϊ�ֽ�����
	 * 
	 * @param hex
	 * @return
	 */
	// @Deprecated
	// public static byte[] hexStringToBytes(String hex) {
	// if (hex == null || "".equals(hex)) {
	// return null;
	// }
	// int len = hex.length() / 2;
	// byte[] result = new byte[len];
	// char[] chArr = hex.toCharArray();
	// for (int i = 0; i < len; i++) {
	// int pos = i * 2;
	// result[i] = (byte) (toByte(chArr[pos]) << 4 | toByte(chArr[pos + 1]));
	// }
	// return result;
	// }

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		// toUpperCase���ַ����е������ַ�ת��Ϊ��д
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		// toCharArray�����ַ���ת��Ϊһ���µ��ַ����顣
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4
					| charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	// charToByte������ָ���ַ��ĵ�һ���������ַ����е�������������ƥ���ַ�
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	/**
	 * ��16�����ַ���ת��Ϊ�ֽ�����
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexToBytes(String hex) {
		if (hex.length() % 2 != 0)
			throw new IllegalArgumentException(
					"input string should be any multiple of 2!");
		hex.toUpperCase();

		byte[] byteBuffer = new byte[hex.length() / 2];

		byte padding = 0x00;
		boolean paddingTurning = false;
		for (int i = 0; i < hex.length(); i++) {
			if (paddingTurning) {
				char c = hex.charAt(i);
				int index = indexOf(hex, c);
				padding = (byte) ((padding << 4) | index);
				byteBuffer[i / 2] = padding;
				padding = 0x00;
				paddingTurning = false;
			} else {
				char c = hex.charAt(i);
				int index = indexOf(hex, c);
				padding = (byte) (padding | index);
				paddingTurning = true;
			}

		}
		return byteBuffer;
	}

	private static int indexOf(String input, char c) {
		int index = ArrayUtils.indexOf(HEX_VOCABLE, c);

		if (index < 0) {
			throw new IllegalArgumentException("err input:" + input);
		}
		return index;

	}

	/**
	 * ��BCD������ֽ�����ת��Ϊ�ַ���
	 * 
	 * @param bcds
	 * @return
	 */
	public static String bcdToString(byte[] bcds) {
		if (bcds == null || bcds.length == 0) {
			return null;
		}
		byte[] temp = new byte[2 * bcds.length];
		for (int i = 0; i < bcds.length; i++) {
			temp[i * 2] = (byte) ((bcds[i] >> 4) & 0x0f);
			temp[i * 2 + 1] = (byte) (bcds[i] & 0x0f);
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			res.append(ascii[temp[i]]);
		}
		return res.toString();
	}

	/**
	 * �ֽ�ת����
	 * 
	 * @param value
	 * @return
	 */
	public static int bcdToInt(byte value) {
		return ((value >> 4) * 10) + (value & 0x0F);
	}

	/**
	 * �ֽ�����ת16�����ַ���
	 * 
	 * @param bs
	 * @return
	 */
	public static String bytesToHex(byte[] bs) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bs) {
			int high = (b >> 4) & 0x0f;
			int low = b & 0x0f;
			sb.append(HEX_VOCABLE[high]);
			sb.append(HEX_VOCABLE[low]);
		}
		return sb.toString();
	}

	/**
	 * �ֽ�����ȡǰlen���ֽ�ת16�����ַ���
	 * 
	 * @param bs
	 * @param len
	 * @return
	 */
	public static String bytesToHex(byte[] bs, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			byte b = bs[i];
			int high = (b >> 4) & 0x0f;
			int low = b & 0x0f;
			sb.append(HEX_VOCABLE[high]);
			sb.append(HEX_VOCABLE[low]);
		}
		return sb.toString();
	}
	/**
	 * �ֽ�����ƫ��offset����֮���ȡlen���ֽ�ת16�����ַ���
	 * 
	 * @param bs
	 * @param offset
	 * @param len
	 * @return
	 */
	public static String bytesToHex(byte[] bs, int offset, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			byte b = bs[offset + i];
			int high = (b >> 4) & 0x0f;
			int low = b & 0x0f;
			sb.append(HEX_VOCABLE[high]);
			sb.append(HEX_VOCABLE[low]);
		}
		return sb.toString();
	}
	/**
	 * �ֽ�����ת16�����ַ���
	 * 
	 * @param bs
	 * @return
	 */
	public static String byteToHex(byte b) {
		StringBuilder sb = new StringBuilder();
		int high = (b >> 4) & 0x0f;
		int low = b & 0x0f;
		sb.append(HEX_VOCABLE[high]);
		sb.append(HEX_VOCABLE[low]);
		return sb.toString();
	}
	/**
	 * ���ֽ�����ȡ��
	 * 
	 * @param src
	 * @return
	 */
	public static String negate(byte[] src) {
		if (src == null || src.length == 0) {
			return null;
		}
		byte[] temp = new byte[2 * src.length];
		for (int i = 0; i < src.length; i++) {
			byte tmp = (byte) (0xFF ^ src[i]);
			temp[i * 2] = (byte) ((tmp >> 4) & 0x0f);
			temp[i * 2 + 1] = (byte) (tmp & 0x0f);
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			res.append(ascii[temp[i]]);
		}
		return res.toString();
	}

	/**
	 * �Ƚ��ֽ������Ƿ���ͬ
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean compareBytes(byte[] a, byte[] b) {
		if (a == null || a.length == 0 || b == null || b.length == 0
				|| a.length != b.length) {
			return false;
		}
		if (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	/**
	 * ֻ�ȶ�ָ������byte
	 * 
	 * @param a
	 * @param b
	 * @param len
	 * @return
	 */
	public static boolean compareBytes(byte[] a, byte[] b, int len) {
		if (a == null || a.length == 0 || b == null || b.length == 0
				|| a.length < len || b.length < len) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ���ֽ�����ת��Ϊ�������ַ���
	 * 
	 * @param items
	 * @return
	 */
	public static String bytesToBinaryString(byte[] items) {
		if (items == null || items.length == 0) {
			return null;
		}
		StringBuffer buf = new StringBuffer();
		for (byte item : items) {
			buf.append(byteToBinaryString(item));
		}
		return buf.toString();
	}

	/**
	 * ���ֽ�ת��Ϊ�������ַ���
	 * 
	 * @param items
	 * @return
	 */
	public static String byteToBinaryString(byte item) {
		byte a = item;
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			buf.insert(0, a % 2);
			a = (byte) (a >> 1);
		}
		return buf.toString();
	}

	/**
	 * ������a��b�����������
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static byte[] xor(byte[] a, byte[] b) {
		if (a == null || a.length == 0 || b == null || b.length == 0
				|| a.length != b.length) {
			return null;
		}
		byte[] result = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = (byte) (a[i] ^ b[i]);
		}
		return result;
	}

	/**
	 * ������a��b����������� ���㳤��len
	 * 
	 * @param a
	 * @param b
	 * @param len
	 * @return
	 */
	public static byte[] xor(byte[] a, byte[] b, int len) {
		if (a == null || a.length == 0 || b == null || b.length == 0) {
			return null;
		}
		if (a.length < len || b.length < len) {
			return null;
		}
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++) {
			result[i] = (byte) (a[i] ^ b[i]);
		}
		return result;
	}
	/**
	 * ��short������ֵת��Ϊ�ֽ�����
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] shortToBytes(int num) {
		byte[] temp = new byte[2];
		for (int i = 0; i < 2; i++) {
			temp[i] = (byte) ((num >>> (8 - i * 8)) & 0xFF);
		}
		return temp;
	}

	/**
	 * ���ֽ�����תΪ����
	 * 
	 * @param num
	 * @return
	 */
	public static int bytesToShort(byte[] arr) {
		int mask = 0xFF;
		int temp = 0;
		int result = 0;
		for (int i = 0; i < 2; i++) {
			result <<= 8;
			temp = arr[i] & mask;
			result |= temp;
		}
		return result;
	}

	/**
	 * ��������ֵת��Ϊָ�����ȵ��ֽ�����
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] intToBytes(int num) {
		byte[] temp = new byte[4];
		for (int i = 0; i < 4; i++) {
			temp[i] = (byte) ((num >>> (24 - i * 8)) & 0xFF);
		}
		return temp;
	}

	/**
	 * ��������ֵת��Ϊָ�����ȵ��ֽ�����
	 * 
	 * @param src
	 * @param len
	 * @return
	 */
	public static byte[] intToBytes(int src, int len) {
		if (len < 1 || len > 4) {
			return null;
		}
		byte[] temp = new byte[len];
		for (int i = 0; i < len; i++) {
			temp[len - 1 - i] = (byte) ((src >>> (8 * i)) & 0xFF);
		}
		return temp;
	}

	/**
	 * ���ֽ�����ת��Ϊ������ֵ
	 * 
	 * @param arr
	 * @return
	 */
	public static int bytesToInt(byte[] arr) {
		int mask = 0xFF;
		int temp = 0;
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result <<= 8;
			temp = arr[i] & mask;
			result |= temp;
		}
		return result;
	}

	/**
	 * ��long������ֵת��Ϊ�ֽ�����
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] longToBytes(long num) {
		byte[] temp = new byte[8];
		for (int i = 0; i < 8; i++) {
			temp[i] = (byte) ((num >>> (56 - i * 8)) & 0xFF);
		}
		return temp;
	}

	/**
	 * ���ֽ�����ת��Ϊlong������ֵ
	 * 
	 * @param arr
	 * @return
	 */
	public static long bytesToLong(byte[] arr) {
		int mask = 0xFF;
		int temp = 0;
		long result = 0;
		int len = Math.min(8, arr.length);
		for (int i = 0; i < len; i++) {
			result <<= 8;
			temp = arr[i] & mask;
			result |= temp;
		}
		return result;
	}

	/**
	 * ��16�����ַ�ת��Ϊ�ֽ�
	 * 
	 * @param c
	 * @return
	 */
	public static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/**
	 * �����������������ֽڵ��ֽ�����ת��Ϊ�������ݣ���λ���㣬���磺<br/>
	 * ���ֽ�����byte[] data = new byte[]{1,2};ת����int���ݵ��ֽڷֲ����£�<br/>
	 * 00000000 00000000 00000001 00000010,��������258
	 * 
	 * @param lenData
	 *            ��Ҫ����ת�����ֽ�����
	 * @return �ֽ���������ʾ����ֵ�Ĵ�С
	 */
	public static int bytesToIntWhereByteLengthEquals2(byte lenData[]) {
		if (lenData.length != 2) {
			return -1;
		}
		byte fill[] = new byte[]{0, 0};
		byte real[] = new byte[4];
		System.arraycopy(fill, 0, real, 0, 2);
		System.arraycopy(lenData, 0, real, 2, 2);
		int len = byteToInt(real);
		return len;

	}

	/**
	 * ������������byte����ת��Ϊint���͵�����
	 * 
	 * @param byteVal
	 *            ��Ҫת�����ֽ�����
	 * @return �ֽ���������ʾ����������
	 */
	public static int byteToInt(byte[] byteVal) {
		int result = 0;
		for (int i = 0; i < byteVal.length; i++) {
			int tmpVal = (byteVal[i] << (8 * (3 - i)));
			switch (i) {
				case 0 :
					tmpVal = tmpVal & 0xFF000000;
					break;
				case 1 :
					tmpVal = tmpVal & 0x00FF0000;
					break;
				case 2 :
					tmpVal = tmpVal & 0x0000FF00;
					break;
				case 3 :
					tmpVal = tmpVal & 0x000000FF;
					break;
			}

			result = result | tmpVal;
		}
		return result;
	}
	public static byte CheckXORSum(byte[] bData) {
		byte sum = 0x00;
		for (int i = 0; i < bData.length; i++) {
			sum ^= bData[i];
		}
		return sum;
	}
	/**
	 * ��offset��ʼ ����������Ϊlen��byte�ֽ�תΪint
	 * 
	 * @param data
	 * @param offset
	 * @param len
	 * @return
	 */
	public static int bytesToInt(byte[] data, int offset, int len) {
		int mask = 0xFF;
		int temp = 0;
		int result = 0;
		len = Math.min(len, 4);
		for (int i = 0; i < len; i++) {
			result <<= 8;
			temp = data[offset + i] & mask;
			result |= temp;
		}
		return result;
	}

	/**
	 * byte�ֽ������е��ַ����ĳ���
	 * 
	 * @param data
	 * @return
	 */
	public static int getBytesStringLen(byte[] data) {
		int count = 0;
		for (byte b : data) {
			if (b == 0x00)
				break;
			count++;
		}
		return count;
	}

	/**
	 * У���
	 * 
	 * @param msg
	 *            ��Ҫ����У��͵�byte����
	 * @param length
	 *            У���λ��
	 * @return �������У�������
	 */
	public static byte[] sumCheck(byte[] msg, int length) {
		long mSum = 0;
		byte[] mByte = new byte[length];

		/** ��Byte���λ���� */
		for (byte byteMsg : msg) {
			long mNum = ((long) byteMsg >= 0)
					? (long) byteMsg
					: ((long) byteMsg + 256);
			mSum += mNum;
		} /** end of for (byte byteMsg : msg) */

		/** λ����ת��ΪByte���� */
		for (int liv_Count = 0; liv_Count < length; liv_Count++) {
			mByte[length - liv_Count
					- 1] = (byte) (mSum >> (liv_Count * 8) & 0xff);
		} /** end of for (int liv_Count = 0; liv_Count < length; liv_Count++) */

		return mByte;
	}

	/**
	 * �ֽ�����תʮ�����ַ�(����-�޷���)
	 * 
	 * @param data
	 * @return
	 */
	public static String getByteToStr(byte[] data) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 0) {
				int tem = data[i] + 256;
				str.append(tem + " ");
			} else {
				str.append(data[i] + " ");
			}
		}
		return str.toString();
	}
	
	 /**
	  * �ϲ��ֽ�����
	 * @param byte_1
	 * @param byte_2
	 * @return
	 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2){  
	        byte[] byte_3 = new byte[byte_1.length+byte_2.length];  
	        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);  
	        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);  
	        return byte_3;  
	    }  
	
	
	/**
	 * ��ȡ�ֽ�����ָ������
	 * @param src
	 * @param begin
	 * @param count
	 * @return
	 */
	public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }


}