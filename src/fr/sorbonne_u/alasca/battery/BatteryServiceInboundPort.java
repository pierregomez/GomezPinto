package fr.sorbonne_u.alasca.battery;


import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class BatteryServiceInboundPort extends AbstractInboundPort implements BatteryServiceCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3875018977842718750L;

	public BatteryServiceInboundPort(ComponentI owner)
			throws Exception {
		super(BatteryServiceCI.class, owner);
	}
	
	public BatteryServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, BatteryServiceCI.class, owner);
	}

	@Override
	public double getMax() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((Battery)c).getMax());
	}

	@Override
	public double currentState() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Battery)c).getCurrentState());
	}

}
