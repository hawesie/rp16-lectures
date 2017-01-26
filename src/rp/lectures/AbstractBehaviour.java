package rp.lectures;

import rp.config.WheeledRobotConfiguration;
import rp.systems.WheeledRobotSystem;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public abstract class AbstractBehaviour implements Behavior {

	protected DifferentialPilot m_pilot;
	protected boolean m_suppressed = false;
	protected WheeledRobotConfiguration m_config;

	public AbstractBehaviour(WheeledRobotConfiguration _config) {
		m_config = _config;
		m_pilot = new WheeledRobotSystem(_config).getPilot();
	
	}

	@Override
	public void suppress() {
		m_suppressed = true;
	}

}
