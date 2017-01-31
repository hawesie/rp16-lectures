package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
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

		float setPoint = 50;
		float output = 0;

		while (m_run) {
			float value = mic.readValue();

			System.out.println(value);
		}

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new FeedbackDemo(SensorPort.S2);
		demo.run();

	}

}
