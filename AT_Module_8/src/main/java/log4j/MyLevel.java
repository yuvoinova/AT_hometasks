package log4j;

import org.apache.log4j.Level;


public class MyLevel extends Level {

	public MyLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static MyLevel toLevel(int val, Level defaultLevel) {
		return STATISTICS;
	}

	public static MyLevel toLevel(String sArg, Level defaultLevel) {

		return STATISTICS;

	}

	public static final MyLevel STATISTICS = new MyLevel(25000, "STATISTICS", 5);
}
