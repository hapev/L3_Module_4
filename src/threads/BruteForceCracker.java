package threads;

// Below is a completed program that uses brute force to crack a 9-digit password. 
// On average, the program takes about 0.125 seconds to find the password.
// Your goal is to re-write the algorithm using Threads. Try to shorten the time it takes 
// to find the code to be as little as possible.
// Let's see who can crack the code the fastest!

// Pro-tip: Do not include the creation of the threads as part of the time. 

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class BruteForceCracker {
	static long code = (long) (new Random().nextDouble() * 1_000_000_000);

	static long startTime;
	static long endTime;
	static float elapsedTime;
	public static AtomicBoolean done = new AtomicBoolean(false);

	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
		startTime = System.currentTimeMillis();

		int ctr = 0;
		int n = 7;
		long l = 1_000_000_000 / n;
		Thread[] threadArray = new Thread[n];
		for (int i = 0; i < n; i++) {
			long min = i * l;
			long max = (i + 1) * l;
			threadArray[i] = new Thread(() -> checkRange(min, max));
		}
		for (Thread t : threadArray) {
			t.start();
		}
		System.out.println(done);
		while (done.get() == false)
			;
		endTime = System.currentTimeMillis();
		elapsedTime = (float) (endTime - startTime);
		elapsedTime /= 1000.f;
		System.out.println("Total time taken: " + elapsedTime + " seconds");
	}

	public static void checkRange(long start, long end) {
		long ctr = start;
		while (!done.get() && !checkCode(ctr++) && ctr < end)
			;
		if (ctr < end) {
			done.getAndSet(true);
		}
		System.out.println(ctr);
	}

	public static boolean checkCode(long p) {
		if (p == code) {
			System.out.println(code);
			// done = true;
			return true;
		} else {
			return false;
		}
	}
}
