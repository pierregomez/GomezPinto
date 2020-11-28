package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class WindTurbineControlOutboundPort extends AbstractOutboundPort implements WindTurbineControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindTurbineControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, WindTurbineControlCI.class, owner);
	}

	@Override
	public void switchOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getWindSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPower() {
		// TODO Auto-generated method stub
		return 0;
	}



}
