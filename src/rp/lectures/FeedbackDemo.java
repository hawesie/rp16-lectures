package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.SoundSensor;
import lejos.util.Delay;
import rp.systems.RobotProgrammingDemo;

public class FeedbackDemo extends RobotProgrammingDemo {

	private final SensorPort port;

	public FeedbackDemo(SensorPort _port) {
		this.port = _port;
	}

	@Override
	public void run() {
		redirectOutput();

		SoundSensor mic = new SoundSensor(port);

		float setpoint = 50;
		float output = 0;
		int delay = 100;

		float P = 0.1f;
		
		while (m_run) {

			Sound.playTone(1000, delay, (int) output);
			Delay.msDelay((long) (delay * 0.4));

			float value = mic.readValue();

			float error = setpoint - value;

			output += (P * error);

			output = Math.max(output, 0);
			output = Math.min(output, 100);

			System.out.println("------");
			System.out.println("value:" + value);
			System.out.println("error:" + error);
			System.out.println("new o:" + output);

			Delay.msDelay((long) (delay * 0.4));
		}

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new FeedbackDemo(SensorPort.S2);
		demo.run();

	}

}
