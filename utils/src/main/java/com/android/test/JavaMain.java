package com.android.test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.android.model.DataState;
import com.android.utils.BytesUtils;
import com.android.utils.DateFormatUtil;
import com.android.utils.JDateUtils;

@SuppressWarnings("unused")
public class JavaMain {
	static byte totals[]=new byte[0];
	public static void main(String[] args) {
		
		//ȥ��
//		byte let[]=new byte[]{0x01,0x05,0,0,0,0,0,0,0,0,0,0,0,0,0,0};  //2
//		byte let1[]=new byte[]{};
//		byte tem[]=new byte[2];
//		for(int i=0;i<2;i++){
//			tem[i]=let[i];
//		}
//		System.out.println(ArrayUtils.toString(byteMerger(let1, tem)));
//		System.out.println(subBytes(let, 0, 2));
		
		//����
	
			System.out.println(BytesUtils.bytesToHex("С�ϻ�".getBytes()));
			System.out.println(ArrayUtils.toString("С�ϻ�".getBytes()));
	
	
		
		//����
//		String hexa="BE 00 14 00 01 00 00 00 00 00 00 00 00 00 00 01 02 00 02 02 01 01 01 DD";
//		hexa=hexa.replace(" ", "");
//		System.out.println(hexa);
//		System.out.println("�ֽڣ�"+ArrayUtils.toString(BytesUtils.hexStringToBytes(hexa)));
//		
//		byte datas[]=BytesUtils.hexStringToBytes(hexa);
//		
//		
//		byte leng[]=new byte[2];
//		System.out.println(ArrayUtils.toString(datas[1]));
//		System.out.println(ArrayUtils.toString(datas[2]));
//		leng[0]=datas[1];
//		leng[1]=datas[2];
//		System.out.println(BytesUtils.bytesToInt(leng,0,2));
		
		
		
		
//		byte data1[]=new byte[]{1,2};
//		byte data2[]=new byte[]{3,4};
//		byte data3[]=new byte[]{8,(byte)9,(byte) 0xaf,0x0F};
//		
//		totals=byteMerger(totals, data1);
//		totals=byteMerger(totals, data2);
//		totals=byteMerger(totals, data3);
//	
//		System.out.println(ArrayUtils.toString(totals));
//		
//
//		String hex = "7e000f000008dcb6b69f00070008dcb6b69f72";
//		System.out.println("head:" + hex.substring(0, 2));
//		String command = hex.substring(20, 24);
//		String dataLength = hex.substring(2, 6);
//		System.out.println("ʮ������ ���ݳ��ȣ�" + dataLength);
//		System.out.println("���ȣ�" + BytesUtils
//				.bytesToInt(BytesUtils.hexStringToBytes(dataLength), 0, 2));
//		System.err.println("���ݳ��ȣ�" + (BytesUtils.bytesToInt(
//				BytesUtils.hexStringToBytes(dataLength), 0, 2) - 9));
//		System.out.println("����ʮ�����ƴ��룺" + hex.substring(24, 24 + 2 * 6));
//		System.out.println("����ʮ���ƴ��룺" + BytesUtils.getByteToStr(
//				BytesUtils.hexStringToBytes(hex.substring(24, 24 + 2 * 6))));
//
//		String input = "0f0f";
//		System.out.println(
//				ArrayUtils.toString(BytesUtils.hexStringToBytes(input)));
//		System.out.println("У��ͣ�" + ArrayUtils.toString(
//				BytesUtils.SumCheck(BytesUtils.hexStringToBytes(input), 1)));
//		System.out.println("У��ͣ�ʮ����" + BytesUtils.bytesToHex(
//				BytesUtils.SumCheck(BytesUtils.hexStringToBytes(input), 1)));
//		String responseData = "00";
//		// ���ݷ��͵���������װʮ�������ַ�����ʽ����
//		System.out.println("�ֽڣ�" + (responseData.length() / 2 + 9));
//		System.out.println("�ֽڣ�ʮ�����ƣ�" + BytesUtils.bytesToHex(
//				BytesUtils.intToBytes((responseData.length() / 2 + 9), 1)));
//		System.out.println("ʮ���ƣ�"
//				+ BytesUtils.getByteToStr(BytesUtils.hexStringToBytes(input)));
//
//		// ʮ���������� ÿ����λ�ӿո�
//		String res = "AE001E00112233445566000101000000020064000112011A103300010300640000CB";
//		String regex = "(.{2})";
//		res = res.replaceAll(regex, "$1 ");
//		System.out.println("�������" + res);
//
//		// ʮ�����ַ���תʮ�������ַ���
//		String username = "02";
//		System.out.println(
//				"�ֽڣ�" + ArrayUtils.toString(BytesUtils.getBytes(username)));
//		System.out.println("ʮ�������ַ�����"
//				+ BytesUtils.bytesToHex(BytesUtils.getBytes(username)));
//		// ʮ�������ַ���תʮ�����ַ���
//		String usernamehex = BytesUtils
//				.bytesToHex(BytesUtils.getBytes(username));
//		System.out.println("�ֽڣ�"
//				+ ArrayUtils.toString(BytesUtils.hexToBytes(usernamehex)));
//		System.out.println("ʮ�����ַ�����"
//				+ BytesUtils.getString(BytesUtils.hexToBytes(usernamehex)));
//
//		// ��̫������
//		System.out.println("����������ָ�" + getResponseCommand("08090904", "8007"));
//		// ��������
//		System.out.println("���ڷ���ָ�" + getResponseCommand2("08090904", "8007"));
//
//		String hextest = "BE000A800304050808080808017D";
//		// ʮ�������ַ�������ֱ��ת�ֽڣ��м�
//		System.out.println(
//				"hextest �ֽڣ�" + ArrayUtils.toString(hextest.getBytes()));
//		System.out.println("hextest �ֽڣ�"
//				+ ArrayUtils.toString(BytesUtils.hexStringToBytes(hextest)));
//
//		parseHexData(getResponseCommand2("08090904", "8007"));

	}

	// AE000680070809090459
	public static void parseHexData(String hex) {
		if (!StringUtils.isEmpty(hex)) {
			// ͷ����Ϣ
			String head = hex.substring(0, 2);
			String length = hex.substring(2, 6);
			// �Ƿ����
			String command = hex.substring(6, 10);
			// ���ݳ��� ��ȥ9���ֽڵĹ̶�����
			int dataLength = BytesUtils
					.bytesToInt(BytesUtils.hexStringToBytes(length), 0, 2) - 2;
			String data = hex.substring(10, 10 + 2 * dataLength);
			System.out.println("���ֽ�����" + (dataLength + 2 + 4) + " �������ͣ�"
					+ command + " ���ݣ�" + data);
			switch (command) {
				case "0001" :// ��������״̬

					break;
				case "0002" :// ��������״̬

					break;
				case "0003" :// �û�����Ӧ��

					break;
				case "0004" :// ��״̬

					break;
				case "0005" :// ˢ������

					break;
				default :
					break;
			}
		}
	}

	/**
	 * ���ݷ��͵���������װʮ�������ַ�����ʽ���� ���ݳ��� �����ֽ�
	 * 
	 * @param responseData
	 * @param resCommand
	 * @return
	 */
	private static String getResponseCommand(String responseData,
			String resCommand) {
		String len = BytesUtils.bytesToHex(
				BytesUtils.intToBytes((responseData.length() / 2 + 9), 2));
		// ͷ��+����+����+�����豸��+Э����������+����+У���
		String result = "AE" + len + "00" + "080808080808" + resCommand
				+ responseData;
		String xiaoyanhe = result + "59";
		// ����У��� (һ���ֽ�)
		String sum = BytesUtils.bytesToHex(
				BytesUtils.sumCheck(BytesUtils.hexStringToBytes(xiaoyanhe), 1));
		System.out.println("У��ͣ�" + sum);
		result = result + sum;
		return result;
	}

	/**
	 * ���ݷ��͵���������װʮ�������ַ�����ʽ���� ���ݳ��� �����ֽ�
	 * 
	 * @param responseData
	 *            Э�����ݲ���
	 * @param resCommand
	 *            Э����������
	 * @return
	 */
	private static String getResponseCommand2(String responseData,
			String resCommand) {
		String len = BytesUtils.bytesToHex(
				BytesUtils.intToBytes((responseData.length() / 2 + 2), 2));
		// ͷ��+����+Э����������+����+У���
		String result = "AE" + len + resCommand + responseData;
		String xiaoyanhe = result;
		// ����У��� (һ���ֽ�)
		String sum = BytesUtils.bytesToHex(
				BytesUtils.sumCheck(BytesUtils.hexStringToBytes(xiaoyanhe), 1));
		System.out.println("У��ͣ�" + sum);
		result = result + sum;
		return result;
	}

	private static void test11(String TAG, String responseInfo) {
		if (responseInfo != null) {
			if (responseInfo.length() >= 3000) {

				System.out.println("sb.length = " + responseInfo.length());
				int chunkCount = responseInfo.length() / 3000; // integer
																// division
				for (int i = 0; i <= chunkCount; i++) {
					int max = 3000 * (i + 1);
					if (max >= responseInfo.length()) {

						System.out.println("��" + i + "��"
								+ responseInfo.substring(3000 * i));
					} else {

						System.out.println("��" + i + "��"
								+ responseInfo.substring(3000 * i, max));
					}
				}
			} else {

			}
		}
	}

	private static void test10() {
		int i = 1;
		int j = 1;
		String k = "1";
		System.out.println(i + j + k);
	}

	public static Double multiply(Double a, Double b) {
		return a * b;
	}

	// Ĭ��Լ����Կ
	private final static byte[] key = {104, 116, 116, 112, 58, 47, 47, 119, 119,
			119, 46, 117, 98, 116, 111, 98, 46, 99, 111, 109, 47, 101, 114, 112,
			47, 115, 97, 108, 101, 47, 111, 114, 100, 101, 114, 115, 63, 115,
			111, 109, 101, 116, 104, 105, 110, 103};

	private static void test09() {
		String keyApp = null;
		try {
			keyApp = new String(key, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(keyApp);

		try {
			byte[] srtbyte = keyApp.getBytes("UTF-8");
			System.out.println(srtbyte);
			System.out.println(srtbyte.equals(key));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void test08() {
		String str = "123";
		System.out.println(str.substring(0, 1));
		System.out.println(str.substring(1, 2));
		System.out.println(str.substring(2, 3));
		Calendar c = Calendar.getInstance();

		c.set(2016, 5, 4);
		Date before = c.getTime();

		c.set(2016, 5, 5);
		Date now = c.getTime();

		c.set(2016, 5, 6);
		Date after = c.getTime();

		// before����now�����ظ������������жϻ��ʼʱ���Ƿ���
		int compareToBefore = before.compareTo(now);
		System.out.println("compareToBefore = " + compareToBefore);

		int compareToIntNow = now.compareTo(now);
		System.out.println("compareToIntNow = " + compareToIntNow);

		// after����now�������������������жϻ����ʱ���Ƿ���
		int compareToIntAfter = after.compareTo(now);
		System.out.println("compareToIntAfter = " + compareToIntAfter);
	}

	private static void test07() {
		String date = "2017-07-17 11:03:52";
		System.out.println(
				"compareToBefore1 : " + date.compareTo("2017-06-16 11:03:52"));
		System.out.println(
				"compareToBefore2 : " + date.compareTo("2017-05-16 11:03:52"));
		System.out.println(
				"compareToNow1 : " + date.compareTo("2017-07-17 11:03:52"));
		System.out.println("compareToNow2 : " + date.compareTo("2017-07-17"));
		System.out.println(
				"compareToAfter1 : " + date.compareTo("2017-07-18 11:03:52"));
		System.out.println(
				"compareToAfter2 : " + date.compareTo("2017-09-16 11:03:52"));

		String date1 = "2017-11-10 17:23";
		String date2 = "2017-11-10 14:23";
		System.out.println(date1.compareTo(date2));
	}

	private static void test06() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateFormatUtil.getDate4StrDate("2017-11-10 12:09",
				"yyyy-MM-dd HH:mm"));
		calendar.add(Calendar.DATE, -1);// ��������������һ��.����������,������ǰ�ƶ�
		System.out.println(DateFormatUtil.getStrDate4Date(calendar.getTime(),
				"yyyy-MM-dd HH:mm"));
	}

	// System.out.println(DateFormatUtil.getStrDate4Date(DateFormatUtil.getDate4StrDate("2017-08-19
	// 09:12", "yyyyMMdd"), "yyyyMMdd"));
	// System.out.println(getCodeDateByService("2017-11-09 24:00"));
	public static int getCodeDateByService(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateFormatUtil.getDate4StrDate(date, "yyyy-MM-dd HH:mm"));
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour >= 0 && hour < 12) {
			System.out.print("���Ϻ�");
			return 1;
		} else if (hour >= 12 && hour < 18) {
			System.out.print("�����");
			return 2;
		} else if (hour >= 18 && hour < 24) {
			System.out.print("����");
			return 3;
		}
		return 0;
	}

	private static void test05() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateFormatUtil.getDate4StrDate("2017-11-09 12:00",
				"yyyy-MM-dd HH:mm"));
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour < 8) {
			System.out.print("���Ϻ�");
		} else if (hour >= 8 && hour < 11) {
			System.out.print("�����");
		} else if (hour >= 11 && hour < 13) {
			System.out.print("�����");
		} else if (hour >= 13 && hour < 18) {
			System.out.print("�����");
		} else {
			System.out.print("���Ϻ�");
		}
	}

	private static void test04() {
		String path = null;
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
	}

	private static void test03() {
		double f = 3.1586;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
	}

	/**
	 * ���뻻�� mת��Ϊkm
	 * 
	 * @param f
	 * @return
	 */
	public static String test02(float f, String format) {
		try {
			if (f > 1000) {
				return new java.text.DecimalFormat(format).format(f / 1000);
			} else {
				return String.valueOf(f);
			}
		} catch (Exception e) {
			throw new RuntimeException("�������Ϸ�");
		}
	}

	/**
	 * ʱ��ָ�
	 */
	private static void test01() {
		List<DataState> datas = new ArrayList<DataState>();

		datas = JDateUtils.timeAddMuilt("2017-07-13 01:00", "2017-07-13 23:45",
				15);
		System.out.println(JSON.toJSONString(datas));

		// datas= JDateUtils.timeAddMuilt("01:30", "23:45");
		// System.out.println( JSON.toJSONString(datas));

		System.out.println(
				JDateUtils.isToday("2017-07-12 23:59", "yyyy-MM-dd HH:mm"));

		// System.out.println(JDateUtils.daysToNewYear());
	}
	
	//java �ϲ�����byte����  
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2){  
        byte[] byte_3 = new byte[byte_1.length+byte_2.length];  
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);  
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);  
        return byte_3;  
    }  

    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

}
