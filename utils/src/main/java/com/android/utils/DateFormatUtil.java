package com.android.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
    public static String getStrDate4Date(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
    }

	/**
	 * add by gongtao
	 * <P>
	 * 将字符串类型的日期格式 转换为 符合要求的 Date类型的日期格式
	 * </P>
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDate4StrDate(String date, String format) {
		if (date == null || date.trim().equals("")) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat(format);
			try {
				return df.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 根据指定日期,来运算加减乘
	 * 
	 * @param date
	 * @param format
	 * @param value
	 *            add(new Date(),"yyyy-MM-dd HH:mm:ss",-1 * 1 * 60 * 60 * 1000);
	 */
	public static String add(Date date, String format, long value) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		long newValue = date.getTime() + value;
		return df.format(new Date(newValue));
	}
}
