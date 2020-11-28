package fr.sorbonne_u.alasca.fridge;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class FridgeConnector extends AbstractConnector implements FridgeControlCI {


	@Override
	public double emergencyDegree() throws Exception {
		return ((FridgeServiceCI)this.offering).emergencyDegree();
	}

	@Override
	public void switchOff() throws Exception {
		((FridgeServiceCI)this.offering).switchOff();

	}

	@Override
	public void switchOn() throws Exception {
		((FridgeServiceCI)this.offering).switchOn();

	}

	@Override
	public boolean getCurrentState() throws Exception {
		return ((FridgeServiceCI)this.offering).getCurrentState();
	}

}
