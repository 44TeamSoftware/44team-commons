package com.ffteam.commons.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * This class consists of {@code static} utility methods for operating with dates
 */
public class DateUtils {
	
	public static final int YEAR_DIFFERENT = 1900;
	
	/**
	 * Hide constructor
	 */
	private DateUtils() {

	}

	/**
	 * Convert {@link LocalDate} to {@link Date}
	 * 
	 * @param localDate as {@link LocalDate}
	 * @return {@link Date} wrapped by {@link Optional} or empty {@link Optional} if {@code localDate} is {@code null}
	 */
	public static Optional<Date> convert(final LocalDate localDate) {
		if (Objects.isNull(localDate)) {
			return Optional.empty();
		}

		return Optional.of(safeDate(localDate.getYear() - YEAR_DIFFERENT, localDate.getMonthValue() - 1, localDate.getDayOfMonth()));
	}

	/**
	 * Convert {@link Date} to {@link LocalDate}
	 * 
	 * @param date as {@link Date}
	 * @return {@link LocalDate} wrapped by {@link Optional} or empty {@link Optional} if {@code date} is {@code null}
	 */
	@SuppressWarnings("deprecation")
	public static Optional<LocalDate> convert(final Date date) {
		if (Objects.isNull(date)) {
			return Optional.empty();
		}

		return Optional.of(LocalDate.of(date.getYear() + YEAR_DIFFERENT, date.getMonth() + 1, date.getDate()));
	}

	/**
	 * Compares two {@link LocalDate}
	 * 
	 * @param d1 first {@link LocalDate}
	 * @param d2 second {@link LocalDate}
	 * @return the comparator value, negative if less, positive if greater
	 */
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
	
	/**
	 * Compares two {@link Date}
	 * 
	 * @param d1 first {@link Date}
	 * @param d2 second {@link Date}
	 * @return the comparator value, negative if less, positive if greater
	 */
	public static int compare(final Date d1, final Date d2) {
		return compare(
				convert(d1).orElse(null), 
				convert(d2).orElse(null));
	}
	
	/**
	 * Create {@link Date} without warning
	 * 
	 * @param year of {@link Date}
	 * @param month of {@link Date}
	 * @param date of {@link Date}
	 * @return {@link Date} base on parameters
	 */
	@SuppressWarnings("deprecation")
	public static Date safeDate(final int year, final int month, final int date) {
		return new Date(year, month, date);
	}
	
	public static LocalDateTime atBeginOfDay(final LocalDateTime source) {
		if (source == null) {
			return null;
		}
		
		return source
				.withHour(0)
				.withMinute(0)
				.withSecond(0)
				.withNano(0);
	}
	
	public static LocalDateTime atEndOfDay(final LocalDateTime source) {
		if (source == null) {
			return null;
		}
		
		return source
				.withHour(23)
				.withMinute(59)
				.withSecond(59)
				.withNano(999_999_999);
	}
	
	public static long toMilliseconds(final LocalDateTime ldt) {
		return Objects.requireNonNull(ldt).atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
	}

}
