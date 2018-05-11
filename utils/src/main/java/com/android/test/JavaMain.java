package com.android.test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSON;

import com.android.model.DataState;
import com.android.utils.DateFormatUtil;
import com.android.utils.JDateUtils;

@SuppressWarnings("unused")
public class JavaMain {
	// Ĭ��Լ����Կ
	private final static byte[] key = {104, 116, 116, 112, 58, 47, 47, 119, 119,
			119, 46, 117, 98, 116, 111, 98, 46, 99, 111, 109, 47, 101, 114, 112,
			47, 115, 97, 108, 101, 47, 111, 114, 100, 101, 114, 115, 63, 115,
			111, 109, 101, 116, 104, 105, 110, 103};

	public static void main(String[] args) {
		System.out.println(String.valueOf(System.currentTimeMillis()));;
	}
	
	
	private static void test11(String TAG, String responseInfo){
		if (responseInfo != null) {
			if (responseInfo.length() >= 3000) {
			
				System.out.println("sb.length = " + responseInfo.length());
				int chunkCount = responseInfo.length() /3000;     // integer division
				for (int i = 0; i <= chunkCount; i++) {
					int max = 3000 * (i + 1);
					if (max >= responseInfo.length()) {
						
						System.out.println("��"+ i + "��" + responseInfo.substring(3000 * i));
					} else {
				
						System.out.println("��" + i+ "��" + responseInfo.substring(3000 * i, max));
					}
				}
			} else {
		
			}
		}
	}

	private static void test10() {
		int i=1;
		   int j=1;
		   String k="1";
		   System.out.println(i+j+k);
	}

	public static Double multiply(Double a, Double b) {
	        return a * b;
	    }


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

}
