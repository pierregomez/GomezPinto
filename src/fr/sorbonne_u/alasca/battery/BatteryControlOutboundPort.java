package fr.sorbonne_u.alasca.battery;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class BatteryControlOutboundPort extends AbstractOutboundPort implements BatteryControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BatteryControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, BatteryControlCI.class, owner);
	}

	@Override
	public double getMax() throws Exception {
		return ((BatteryControlCI)this.getConnector()).getMax();
	}

	@Override
	public double getCurrentState() throws Exception {
		return ((BatteryControlCI)this.getConnector()).getCurrentState();
	}

}
