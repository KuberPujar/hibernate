package com.learn.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String dateStr) throws ParseException {
		Date dt = dateFormater.parse(dateStr);
		return dt;
	}

	public static String formateDate(Date date) {
		String result = null;

		if (date != null) {
			result = dateFormater.format(date);
		}
		return result;
	}
}
