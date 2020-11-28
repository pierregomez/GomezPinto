package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class WindTurbineOutboundPort extends AbstractOutboundPort implements WindTurbineControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindTurbineOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, WindTurbineControlCI.class, owner);
	}

	@Override
	public void switchOn() throws Exception {
		((WindTurbineControlCI)this.getConnector()).switchOn();

	}

	@Override
	public void switchOff() throws Exception {
		((WindTurbineControlCI)this.getConnector()).switchOn();
	}

	@Override
	public boolean isOn() throws Exception {
		return ((WindTurbineControlCI)this.getConnector()).isOn();
	}

	@Override
	public double getWindSpeed() throws Exception {
		return ((WindTurbineControlCI)this.getConnector()).getWindSpeed();
	}

	@Override
	public double getPower() throws Exception {
		return ((WindTurbineControlCI)this.getConnector()).getPower();
	}

}
