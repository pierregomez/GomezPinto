package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.alasca.URIs;
import fr.sorbonne_u.components.AbstractComponent;

public class EnergyCounter extends AbstractComponent implements EnergyCounterServicesCI {

	protected EnergyCounterServiceInboundPort ecsip;
	
	private double instantConsumption;
	
	protected EnergyCounter(String uri) throws Exception {
		super(uri,1,0);
		this.ecsip = new EnergyCounterServiceInboundPort(URIs.ENERGY_COUNTER_INBOUND_PORT_URI, this);
		this.ecsip.publishPort();

		this.instantConsumption = 0;
	}

	@Override
	public double getInstantConsumption() {
		return this.instantConsumption;
	}
}