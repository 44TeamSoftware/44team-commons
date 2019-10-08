package com.ffteam.commons.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class DateUtils {
	
	private DateUtils() {

	}

	public static Optional<Date> convert(final LocalDate localDate) {
		if (Objects.isNull(localDate)) {
			return Optional.empty();
		}
		
		return Optional.of(
				Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}
	
	public static Optional<LocalDate> convert(final Date date) {
		if (Objects.isNull(date)) {
			return Optional.empty();
		}
		
		return Optional.of(
				date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}
}
