package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class EnergyCounterOutboundPort extends AbstractOutboundPort implements EnergyCounterControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnergyCounterOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, EnergyCounterControlCI.class, owner);
	}

	@Override
	public double getInstantConsumption() throws Exception {
		return ((EnergyCounterControlCI)this.getConnector()).getInstantConsumption();
	}

}
