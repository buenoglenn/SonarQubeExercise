package demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	//
	private final static String PATTERN = "EEE MMM dd HH:mm:ss z yyyy";
	//
	private final static DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(PATTERN, Locale.ENGLISH);
	
	/**
	 * Gets the date without time
	 * @param date
	 * @return
	 */
	public static Date getDateWithoutTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getDateEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * Gets the date tomorrow
	 * @param date
	 * @return
	 */
	public static Date getTomorrowDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * Gets the date yesterday
	 * @param date
	 * @return
	 */
	public static Date getYesterdayDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	/**
	 * Gets the Date last week
	 * @param date
	 * @return
	 */
	public static Date getLastWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dateDiff = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
		calendar.add(Calendar.DATE, -dateDiff -7);
		return calendar.getTime();
	}
	
	/**
	 * Gets the date last month
	 * @param date
	 * @return
	 */
	public static Date getLastMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLast6Months(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -6);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		return calendar.getTime();
	}

	public static DateFormat getSIMPLE_DATE_FORMAT() {
		return SIMPLE_DATE_FORMAT;
	}
}
