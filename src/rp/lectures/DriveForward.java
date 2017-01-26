package rp.lectures;

import rp.config.WheeledRobotConfiguration;
import rp.util.Rate;

public class DriveForward extends AbstractBehaviour {

	public DriveForward(WheeledRobotConfiguration _config) {
		super(_config);
	}

	@Override
	public boolean takeControl() {
		// Always return true as we can always drive forward
		return true;
	}

	@Override
	public void action() {
		m_pilot.forward();
		Rate r = new Rate(20);
		while (!m_suppressed) {
			r.sleep();
		}
		m_pilot.stop();
		m_suppressed = false;
	}

}
