package fr.sorbonne_u.alasca.battery;

import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {BatteryServiceCI.class})
public class Battery  extends AbstractComponent implements BatteryInterface{
	private final double max;	
	private double current;
	
	protected BatteryServiceInboundPort bsip;
	
	protected Battery(String uri, double max) throws Exception {
		super(uri,1,0);
		this.bsip = new BatteryServiceInboundPort(URIs.BATTERY_INBOUND_PORT_URI, this);
		this.bsip.publishPort();
		
		this.max = max;
		this.current = 0;
	}
	
	public double getMax() {
		return this.max;
	}

	public double getCurrentState() {
		return this.current;
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.bsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}

}
