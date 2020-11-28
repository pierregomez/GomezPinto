package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EnergyConnector extends AbstractConnector implements EnergyCounterControlCI {

	@Override
	public double getInstantConsumption() throws Exception {
		return ((EnergyCounterServicesCI)this.offering).getInstantConsumption();
	}

}
