package fr.sorbonne_u.alasca.windTurbine;


import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class WindTurbineServiceInboundPort extends AbstractInboundPort implements WindTurbineServiceCI {

	/**
	 * 
	 */

	private static final long serialVersionUID = -117487331788155645L;

	public WindTurbineServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, WindTurbineServiceCI.class, owner);
	}

	public WindTurbineServiceInboundPort(ComponentI owner)
			throws Exception {
		super(WindTurbineServiceCI.class, owner);
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
