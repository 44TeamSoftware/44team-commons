package com.ffteam.commons.date;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class DateUtils {
	
	public static final int YEAR_DIFFERENT = 1900;
	
	private DateUtils() {

	}

	public static Optional<Date> convert(final LocalDate localDate) {
		if (Objects.isNull(localDate)) {
			return Optional.empty();
		}

		return Optional.of(safeDate(localDate.getYear() - YEAR_DIFFERENT, localDate.getMonthValue() - 1, localDate.getDayOfMonth()));
	}

	@SuppressWarnings("deprecation")
	public static Optional<LocalDate> convert(final Date date) {
		if (Objects.isNull(date)) {
			return Optional.empty();
		}

		return Optional.of(LocalDate.of(date.getYear() + YEAR_DIFFERENT, date.getMonth() + 1, date.getDate()));
	}

	public static int compare(final LocalDate d1, final LocalDate d2) {
		if (d1 == null && d2 == null) {
			return 0;
		}

		if (d1 == null && d2 != null) {
			return -1;
		}

		if (d1 != null && d2 == null) {
			return 1;
		}

		return d1.compareTo(d2);
	}
	
	public static int compare(final Date d1, final Date d2) {
		return compare(
				convert(d1).orElse(null), 
				convert(d2).orElse(null));
	}
	
	@SuppressWarnings("deprecation")
	public static Date safeDate(final int year, final int month, final int date) {
		return new Date(year, month, date);
	}
}
