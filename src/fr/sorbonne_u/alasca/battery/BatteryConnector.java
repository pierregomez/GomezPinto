package fr.sorbonne_u.alasca.battery;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class BatteryConnector extends AbstractConnector implements BatteryControlCI {

	@Override
	public double getMax() throws Exception {
		return ((BatteryServiceCI)this.offering).getMax();
	}

	@Override
	public double getCurrentState() throws Exception {
		return ((BatteryServiceCI)this.offering).getCurrentState();
	}

}
