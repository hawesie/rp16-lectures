package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import rp.config.RobotConfigs;

public class BehaviourDemo {

	public static void main(String[] args) {
		Button.waitForAnyPress();
		Behavior drive = new DriveForward(RobotConfigs.EXPRESS_BOT);
		Behavior bump = new Bump(RobotConfigs.EXPRESS_BOT, SensorPort.S1);
		Arbitrator arby = new Arbitrator(new Behavior[] { drive, bump });
		arby.start();
	}

}
