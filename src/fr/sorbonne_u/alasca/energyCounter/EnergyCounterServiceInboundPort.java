package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class EnergyCounterServiceInboundPort extends AbstractInboundPort implements EnergyCounterServicesCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnergyCounterServiceInboundPort(ComponentI owner)
			throws Exception {
		super(EnergyCounterServicesCI.class, owner);
	}

	public EnergyCounterServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, EnergyCounterServicesCI.class, owner);
	}

	@Override
	public double getInstantConsumption() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((EnergyCounter)c).getInstantConsumption());
	}

}
