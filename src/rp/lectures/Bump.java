package rp.lectures;

import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import rp.config.WheeledRobotConfiguration;

public class Bump extends AbstractBehaviour implements SensorPortListener {

	private boolean beenPressed;

	public Bump(WheeledRobotConfiguration _config, SensorPort _port) {
		super(_config);
		_port.addSensorPortListener(this);
	}

	@Override
	public boolean takeControl() {
		return beenPressed;
	}

	@Override
	public void action() {
		m_pilot.travel(2 * -m_config.getRobotLength());
		m_pilot.rotate(180);
		beenPressed = false;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(SensorPort _aSource, int _aOldValue, int _aNewValue) {
		if (_aNewValue < _aOldValue) {
			beenPressed = true;
			Sound.beepSequenceUp();
		}
	}

}
