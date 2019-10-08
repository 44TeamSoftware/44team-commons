package com.ffteam.commons.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	
	private DateUtils() {

	}

	public static Date convert(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate convert(final Date date) {
		if (date == null) {
			return null;
		}
		
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
