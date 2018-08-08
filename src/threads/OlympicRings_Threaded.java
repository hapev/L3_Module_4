package threads;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot r1 = new Robot(200, 700);
		Robot r2 = new Robot(300, 700);
		Robot r3 = new Robot(400, 700);
		Robot r4 = new Robot(500, 700);
		Robot r5 = new Robot(600, 700);
		Thread t1 = new Thread(() -> circle(r1));
		Thread t2 = new Thread(() -> circle(r2));
		Thread t3 = new Thread(() -> circle(r3));
		Thread t4 = new Thread(() -> circle(r4));
		Thread t5 = new Thread(() -> circle(r5));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	private static void circle(Robot r1) {
		r1.penDown();
		for (int i = 0; i < 365; i++) {
			r1.turn(1);
			r1.move(1);

		}
		r1.hide();
	}
}
