package rp.lectures;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.util.Delay;
import rp.systems.RobotProgrammingDemo;

public class TouchSensorDemo extends RobotProgrammingDemo implements
		SensorPortListener {

	private final SensorPort port;
	private boolean beenPressed;

	public TouchSensorDemo(SensorPort port) {
		this.port = port;
		this.beenPressed = false;
	}

	@Override
	public void run() {
		this.port.addSensorPortListener(this);

		while (m_run) {
			if (beenPressed) {
				Sound.beep();
				Delay.msDelay(100);
				beenPressed = false;
			}

		}
	}

	@Override
	public void stateChanged(SensorPort _aSource, int _aOldValue, int _aNewValue) {
		if (_aNewValue < _aOldValue) {
			beenPressed = true;
		}
	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotProgrammingDemo demo = new TouchSensorDemo(SensorPort.S1);
		demo.run();

	}

}
