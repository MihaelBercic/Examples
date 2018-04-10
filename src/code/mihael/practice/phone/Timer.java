package code.mihael.practice.phone;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import code.mihael.practice.phone.data.MethodEvent;

public class Timer {

	private long start;
	private long stop;
	private long expire;
	private boolean isRunning = false;
	private Map<MethodEvent, Runnable> event = new HashMap<>();

	public void start() {
		start = System.currentTimeMillis();
		isRunning = true;
		Runnable r = getRunnable(MethodEvent.START);
		if (r != null) {
			r.run();
		}
		if (expire != 0) {
			Thread t = new Thread(() -> {
				while (System.currentTimeMillis() - start < expire) {
				}
				if (isRunning) {
					stop();
				}
			});
			t.start();
		}
	}

	public void stop() {
		stop = System.currentTimeMillis();
		isRunning = false;
		Runnable r = getRunnable(MethodEvent.STOP);
		if (r != null) {
			r.run();
		}
	}

	public void setExpire(TimeUnit u, long x) {
		expire = u.toMillis(x);
	}

	public long getExpire(TimeUnit u) {
		return u.convert(expire, TimeUnit.MILLISECONDS);
	}

	public String getTimeAsString() {
		return getTime(stop != 0 ? (stop - start) : System.currentTimeMillis() - start, false);
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void restart() {
		isRunning = false;
		Runnable r = getRunnable(MethodEvent.RESTART);
		if (r != null) {
			r.run();
		}
		start = System.currentTimeMillis();
		isRunning = true;
		if (r != null) { r.run(); }
	}

	public void addActionListener(MethodEvent e, Runnable r) {
		event.put(e, r);
	}

	private Runnable getRunnable(MethodEvent e) {
		return event.entrySet().stream().filter(a -> a.getKey().equals(e)).map(Map.Entry::getValue).findFirst().orElse(null);
	}

	private String getTime(long mili, boolean toMili) {
		long seconds = (mili / 1000) % 60;
		long minutes = (mili / 60000) % 60;
		long hours = (mili / 3600000) % 60;
		return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) + (toMili ? ":" + mili : "");
	}

}
