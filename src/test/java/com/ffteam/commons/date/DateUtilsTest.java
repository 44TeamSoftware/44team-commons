package com.ffteam.commons.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {

	@Test
	public void testConvertToDate() {
		ZoneId zoneId	= ZoneId.of("EST", ZoneId.SHORT_IDS);
		LocalDate localDate = LocalDate.of(2000, 1, 1);
		Optional<Date> expected = Optional.of(new Date(2000-1900, 0, 1));

		Optional<Date> actual = DateUtils.convert(zoneId, localDate);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToDate_whenLocalDateIsNull() {
		ZoneId zoneId	= ZoneId.of("EST", ZoneId.SHORT_IDS);
		LocalDate localDate = null;
		Optional<Date> expected = Optional.empty();

		Optional<Date> actual = DateUtils.convert(zoneId, localDate);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToLocalDate() {
		ZoneId zoneId	= ZoneId.of("EST", ZoneId.SHORT_IDS);
		Date date = new Date(2000-1900, 0, 1);
		Optional<LocalDate> expected = Optional.of(LocalDate.of(2000, 1, 1));

		Optional<LocalDate> actual = DateUtils.convert(zoneId, date);

		assertEquals(expected, actual);
	}

	@Test
	public void testConvertToDate_whenDateIsNull() {
		ZoneId zoneId	= ZoneId.of("EST", ZoneId.SHORT_IDS);
		Date date = null;
		Optional<Date> expected = Optional.empty();

		Optional<LocalDate> actual = DateUtils.convert(zoneId, date);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDate_withBothDatesNull() {
		LocalDate date1 = null;
		LocalDate date2 = null;
		int expected = 0;

		int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDate_withDateOneNull() {
		LocalDate date1 = null;
		LocalDate date2 = LocalDate.of(2000, 12, 3);
		int expected = -1;

		int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareLocalDate_withDateTwoNull() {
		LocalDate date1 = LocalDate.of(2000, 12, 3);
		LocalDate date2 = null;
		int expected = 1;

		int actual = DateUtils.compare(date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDate_withBothDatesNull() {
		Date date1 = null;
		Date date2 = null;
		ZoneId zoneId = ZoneId.of("EST", ZoneId.SHORT_IDS);
		int expected = 0;

		int actual = DateUtils.compare(zoneId, date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDate_withDateOneNull() {
		Date date1 = null;
		Date date2 = new Date(2000-1900, 11, 3);
		ZoneId zoneId = ZoneId.of("EST", ZoneId.SHORT_IDS);
		int expected = -1;

		int actual = DateUtils.compare(zoneId, date1, date2);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompareDate_withDateTwoNull() {
		Date date1 =  new Date(2000-1900, 11, 3);
		Date date2 = null;
		ZoneId zoneId = ZoneId.of("EST", ZoneId.SHORT_IDS);
		int expected = 1;

		int actual = DateUtils.compare(zoneId, date1, date2);

		assertEquals(expected, actual);
	}
}
