package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import rp.config.RobotConfigs;
import rp.config.WheeledRobotConfiguration;
import rp.systems.RobotProgrammingDemo;
import rp.systems.WheeledRobotSystem;
import rp.util.Rate;

public class MotorTest extends RobotProgrammingDemo {

	private WheeledRobotSystem robot;

	public MotorTest(WheeledRobotConfiguration _config) {
		this.robot = new WheeledRobotSystem(_config);
	}

	@Override
	public void run() {

		DifferentialPilot pilot = robot.getPilot();
		Rate r = new Rate(2);
		
		
		while (m_run) {
			pilot.travel(1, true);
			while (pilot.isMoving()) {
				Sound.beep();
				r.sleep();
				if (!m_run) {
					return;
				}
			}

			pilot.rotate(180);
		}
	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new MotorTest(RobotConfigs.EXPRESS_BOT);
		demo.run();
	}

}
