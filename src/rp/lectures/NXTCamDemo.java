package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.NXTCam;
import rp.systems.RobotProgrammingDemo;
import rp.util.Rate;

public class NXTCamDemo extends RobotProgrammingDemo {

	@Override
	public void run() {
		NXTCam cam = new NXTCam(SensorPort.S2);
		cam.setTrackingMode(NXTCam.OBJECT_TRACKING);
		cam.sortBy(NXTCam.SIZE);

		cam.enableTracking(true);

		Rate r = new Rate(5);

		while (m_run) {
			r.sleep();
			System.out.println(cam.getNumberOfObjects());

		}

	}

	public static void main(String[] args) {

		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new NXTCamDemo();
		demo.run();
	}

}