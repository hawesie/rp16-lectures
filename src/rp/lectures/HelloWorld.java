package rp.lectures;
import lejos.nxt.Button;
import rp.systems.RobotProgrammingDemo;

public class HelloWorld extends RobotProgrammingDemo {

	@Override
	public void run() {
		System.out.println("Hello");
		Button.waitForAnyPress();
	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new HelloWorld();
		demo.run();

	}

}
