package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {EnergyCounterServicesCI.class})
public class EnergyCounter extends AbstractComponent implements EnergyCounterInterface {

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
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.ecsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}
}