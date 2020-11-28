package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class WindTurbineConnector extends AbstractConnector implements WindTurbineControlCI {

	@Override
	public void switchOn() throws Exception {
		((WindTurbineServiceCI)this.offering).switchOn();	
	}

	@Override
	public void switchOff() throws Exception {
		((WindTurbineServiceCI)this.offering).switchOff();	
	}

	@Override
	public boolean isOn() throws Exception {
		return ((WindTurbineServiceCI)this.offering).isOn();	
	}

	@Override
	public double getWindSpeed() throws Exception {
		return ((WindTurbineServiceCI)this.offering).getWindSpeed();	

	}

	@Override
	public double getPower() throws Exception {
		return ((WindTurbineServiceCI)this.offering).getPower();	

	}

}
