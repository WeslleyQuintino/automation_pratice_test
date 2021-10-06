package Core;

public class ThreadHelper {
	public static long getThreadId() {
		return Thread.currentThread().getId();
	}

	public static void espera(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
