package fr.sorbonne_u.alasca.fridge;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class FridgeControlOutboundPort extends AbstractOutboundPort implements FridgeControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FridgeControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri,FridgeControlCI.class, owner);
	}


	@Override
	public double emergencyDegree() throws Exception {
		return ((FridgeControlCI)this.getConnector()).emergencyDegree();
	}

	@Override
	public void switchOff() throws Exception {
		((FridgeControlCI)this.getConnector()).switchOff();
		
	}

	@Override
	public void switchOn() throws Exception {
		((FridgeControlCI)this.getConnector()).switchOn();
		
	}

	@Override
	public boolean getCurrentState() throws Exception {
		return ((FridgeControlCI)this.getConnector()).getCurrentState();
	}

}
