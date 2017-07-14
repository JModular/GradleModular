package com.android.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.android.model.*;

/**
 * @des 业务处理日期工具类
 * 
 * @author Arison
 *
 */
public class JDateUtils {

	/**
	 * 时间段分割 返回指定时间段内 循环累加半小时
	 *
	 * @param start
	 * @param end
	 *            08:30-12:30 [首 +中间值累加半小时 + 尾]
	 * @return
	 */
	public static List<DataState> timeAddMuilt(String start, String end, int minute) {
		List<DataState> result = new ArrayList<>();
		DataState dataState = new DataState();
		dataState.setValue(start.substring(11, 16));
		dataState.setClicked(true);
		result.add(dataState);
		while (true) {
			start = DateFormatUtil.add(
					DateFormatUtil.getDate4StrDate(start, "yyyy-MM-dd HH:mm"),
					"yyyy-MM-dd HH:mm",
					1 * 1 * minute * 60 * 1000);
			if (start.compareTo(end) >= 0) {
				DataState dataState1 = new DataState();
				dataState1.setValue(end.substring(11, 16));
				dataState1.setClicked(true);
				result.add(dataState1);
				break;
			} else {
				DataState dataState2 = new DataState();
				dataState2.setValue(start.substring(11, 16));
				dataState2.setClicked(true);
				result.add(dataState2);
			}
		}
		return result;
	}

    /**
     * 返回指定时间段内  循环累加半小时
     *
     * @param start
     * @param end   08:30-12:30  [首 +中间值累加半小时 + 尾]
     * @return
     */
    public static List<DataState> timeAddMuilt(String start, String end) {  
        List<DataState> result = new ArrayList<>();
        DataState dataState = new DataState();
        dataState.setValue(start);
        dataState.setClicked(true);
        result.add(dataState);
        while (true) {
            start = DateFormatUtil.add(DateFormatUtil.getDate4StrDate(start, "HH:mm"),
                    "HH:mm", 1 * 1 * 30 * 60 * 1000);
            System.out.println(start);
            if (start.compareTo(end) >= 0) {
                DataState dataState1 = new DataState();
                dataState1.setValue(end);
                dataState1.setClicked(true);
                result.add(dataState1);
                break;
            } else {
                DataState dataState2 = new DataState();
                dataState2.setValue(start);
                dataState2.setClicked(true);
                result.add(dataState2);
            }
           
        }
     
        return result;
    }
	
	/**
	 * 是否是今天
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static boolean isToday(String time, String format) {
		boolean isToday = false;
		Calendar current = Calendar.getInstance();
		Calendar today = Calendar.getInstance(); // 今天
		today.setTime(new Date());

		int year_today = today.get(Calendar.YEAR);
		int month_today = today.get(Calendar.MONTH) + 1;
		int day_today = today.get(Calendar.DAY_OF_MONTH);

		Date date = DateFormatUtil.getDate4StrDate(time, format);
		current.setTime(date);

		int year_current = current.get(Calendar.YEAR);
		int month_current = current.get(Calendar.MONTH) + 1;
		int day_current = current.get(Calendar.DAY_OF_MONTH);

		if (year_today == year_current && month_today == month_current && day_today == day_current) {
			return true;
		}
		return isToday;
	}
	
	
	public static int daysToNewYear() {
		LocalDate fromDate = new LocalDate();
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		return Days.daysBetween(fromDate, newYear).getDays();
	}

}
