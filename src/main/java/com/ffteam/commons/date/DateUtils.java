package com.ffteam.commons.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class DateUtils {

	private DateUtils() {

	}

	public static Optional<Date> convert(final ZoneId zoneId, final LocalDate localDate) {
		if (Objects.isNull(localDate)) {
			return Optional.empty();
		}

		return Optional.of(Date.from(localDate.atStartOfDay(zoneId).toInstant()));
	}

	public static Optional<LocalDate> convert(final ZoneId zoneId, final Date date) {
		if (Objects.isNull(date)) {
			return Optional.empty();
		}

		return Optional.of(date.toInstant().atZone(zoneId).toLocalDate());
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
	
	public static int compare(final ZoneId zoneId, final Date d1, final Date d2) {
		return compare(
				convert(zoneId, d1).orElse(null), 
				convert(zoneId, d2).orElse(null));
	}
}
