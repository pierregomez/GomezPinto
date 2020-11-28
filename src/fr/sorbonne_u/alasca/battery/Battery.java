package fr.sorbonne_u.alasca.battery;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {BatteryServiceCI.class})
public class Battery  extends AbstractComponent implements BatteryServiceCI{
	private final double max;	
	private double current;
	
	public static final String CSIP_URI = "Battery_CSIP_URI";
	protected BatteryServiceInboundPort csip;
	
	protected Battery(double max) throws Exception {
		super(1,0);
		this.csip = new BatteryServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
		
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
			this.csip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}

}
