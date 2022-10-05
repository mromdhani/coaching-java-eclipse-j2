package lu.cronos._06_java_flight_recorder;

public class DemoThreadDeadLock {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) {
		ThreadDemo1 t1 = new ThreadDemo1("Thread Demo 1");
		ThreadDemo2 t2 = new ThreadDemo2("Thread Demo 2");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Fin du programme");
	}

	private static class ThreadDemo1 extends Thread {
		public ThreadDemo1(String name) {
			super(name);
		}

		public void run() {
			synchronized (Lock1) {
				System.out.println("Thread 1: Holding lock 1...");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for lock 2...");

				synchronized (Lock2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}

	private static class ThreadDemo2 extends Thread {
		public ThreadDemo2(String nom) {
			super(nom);
		}

		public void run() {
			synchronized (Lock2) {
				System.out.println("Thread 2: Holding lock 2...");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for lock 1...");

				synchronized (Lock1) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	}
}
