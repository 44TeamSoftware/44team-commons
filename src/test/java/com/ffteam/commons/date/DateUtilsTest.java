package com.ffteam.commons.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class DateUtilsTest {
	
	@Test
	public void testConvertToDate() {
		final LocalDate localDate = LocalDate.of(2000, 1, 1);
		
		@SuppressWarnings("deprecation")
		final Optional<Date> expected = Optional.of(new Date(2000 - 1900, 0, 1));

		final Optional<Date> actual = DateUtils.convert(localDate);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToDateWhenLocalDateIsNull() {
		final LocalDate localDate = null;
		final Optional<Date> expected = Optional.empty();

		final Optional<Date> actual = DateUtils.convert(localDate);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToLocalDate() {
		@SuppressWarnings("deprecation")
		final Date date = new Date(2000 - 1900, 0, 1);
		final Optional<LocalDate> expected = Optional.of(LocalDate.of(2000, 1, 1));

		final Optional<LocalDate> actual = DateUtils.convert(date);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToDateWhenDateIsNull() {
		final Date date = null;
		final Optional<Date> expected = Optional.empty();

		final Optional<LocalDate> actual = DateUtils.convert(date);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDateWithBothDatesNull() {
		final LocalDate date1 = null;
		final LocalDate date2 = null;
		final int expected = 0;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDateWithDateOneNull() {
		final LocalDate date1 = null;
		final LocalDate date2 = LocalDate.of(2000, 12, 3);
		final int expected = -1;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDateWithDateTwoNull() {
		final LocalDate date1 = LocalDate.of(2000, 12, 3);
		final LocalDate date2 = null;
		final int expected = 1;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDateWithBothDatesNull() {
		final Date date1 = null;
		final Date date2 = null;
		final int expected = 0;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDateWithDateOneNull() {
		final Date date1 = null;
		
		@SuppressWarnings("deprecation")
		final Date date2 = new Date(2000 - 1900, 11, 3);
		final int expected = -1;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDateWithDateTwoNull() {
		@SuppressWarnings("deprecation")
		final Date date1 = new Date(2000 - 1900, 11, 3);
		final Date date2 = null;
		final int expected = 1;

		final int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testSafeDate() {
		final int year = 2000;
		final int month = 3;
		final int day = 15;
		
		@SuppressWarnings("deprecation")
		final Date expected = new Date(year, month, day);

		final Date actual = DateUtils.safeDate(year, month, day);

		assertEquals(expected, actual);
	}
}
