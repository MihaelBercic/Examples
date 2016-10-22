package code.mihael.query.api;

import java.util.Random;

public class Functions {

	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) + min;
	}

	public static boolean arrayContains(int[] array, int integer) {
		for (int o : array) {
			if (o == integer) {
				return true;
			}
		}
		return false;
	}

	public static String getTime(long mili, boolean toMili) {
		long seconds = (mili / 1000) % 60;
		long minutes = (mili / 60000) % 60;
		long hours = (mili / 3600000) % 60;
		return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) + (toMili ? ":" + mili : "");
	}

}
