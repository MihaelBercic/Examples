package code.mihael.query.api;

public class StopWatch {

	private long start = 0, stop = 0;

	public void start() {
		start = System.currentTimeMillis();
	}

	public void stop() {
		stop = System.currentTimeMillis();
	}

	public long getDuration() {
		return stop - start;
	}

	public String getDurationAsString(boolean miliPrecise) {
		return Functions.getTime(stop - start, miliPrecise);
	}

}
