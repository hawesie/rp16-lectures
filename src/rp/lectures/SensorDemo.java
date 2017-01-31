package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.RangeFinder;
import lejos.util.Delay;
import rp.systems.RobotProgrammingDemo;

public class SensorDemo extends RobotProgrammingDemo {

	private final SensorPort port;

	public SensorDemo(SensorPort _port) {
		this.port = _port;
	}

	@Override
	public void run() {

		redirectOutput();

		RangeFinder sensor = new OpticalDistanceSensor(port);

		int delay = 100;

		float minRange = 10;
		float maxRange = 80;
		float rangeRange = maxRange - minRange;

		float minTone = 400;
		float maxTone = 4000;
		float toneRange = maxTone - minTone;

		while (m_run) {
			float value = sensor.getRange();
			float rangeRatio = (value - minRange) / rangeRange;

			float outputTone = minTone + (toneRange * rangeRatio);

			Sound.playTone((int) outputTone, delay);

			System.out.println("-----");
			System.out.println("sensor: " + value);
			System.out.println("out: " + outputTone);

			Delay.msDelay((long) (delay * 0.9));

		}

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new SensorDemo(SensorPort.S2);
		demo.run();

	}

}
