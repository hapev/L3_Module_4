package threads;

public class ThreadedReverseGreeting {

	public static void main(String[] args) {
		int id = 0;
		run(id);
	}

	// Write a program that creates a thread (Thread 1) that creates another thread
	// (Thread 2);
	// Thread 2 creates Thread 3; and so on, up to Thread 50.
	// Each thread should print "Hello from Thread <num>!",
	// but you should structure your program such that the threads print their
	// greetings in reverse order.
	public static void run(int i) {

		if (i < 50) {
			Thread t = new Thread(() -> run(i + 1));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Hello from Thread " + i);

	}

}
