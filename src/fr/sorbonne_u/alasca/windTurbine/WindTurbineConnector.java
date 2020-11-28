package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class WindTurbineConnector extends AbstractConnector implements WindTurbineControlCI {

	@Override
	public void switchOn() throws Exception {
		((WindTurbineControlCI)this.offering).switchOn();	
	}

	@Override
	public void switchOff() throws Exception {
		((WindTurbineControlCI)this.offering).switchOff();	
	}

	@Override
	public boolean isOn() throws Exception {
		return ((WindTurbineControlCI)this.offering).isOn();	
	}

	@Override
	public double getWindSpeed() throws Exception {
		return ((WindTurbineControlCI)this.offering).getWindSpeed();	

	}

	@Override
	public double getPower() throws Exception {
		return ((WindTurbineControlCI)this.offering).getPower();	

	}

}
