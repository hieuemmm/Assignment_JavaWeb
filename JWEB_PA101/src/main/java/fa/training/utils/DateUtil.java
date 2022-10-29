package fa.training.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
	private static final LocalDateTime localDateTime = LocalDateTime.now();

	public static String getDate() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINESE).format(localDateTime);
	}

	public static String getTime() {
		return DateTimeFormatter.ofPattern("hh:mm", Locale.CHINESE).format(localDateTime);
	}
	public static String getDateTime() {
		return getDate() + " " + getTime();
	}
}
