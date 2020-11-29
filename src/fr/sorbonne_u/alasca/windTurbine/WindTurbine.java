package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {WindTurbineServiceCI.class})
public class WindTurbine extends AbstractComponent implements WindTurbineInterface {
	
	protected WindTurbineServiceInboundPort wsip;
	
	private boolean isOn;
	private double windSpeed;
	private double powerOutput_W;
	

	protected WindTurbine(String uri) throws Exception {
		super(uri,1,0);
		this.wsip = new WindTurbineServiceInboundPort(URIs.WINDTURBINE_INBOUND_PORT_URI, this);
		this.wsip.publishPort();
		
		this.isOn = false;
		this.windSpeed = 0;
		this.powerOutput_W = 0;

	}

	@Override
	public void switchOn() {
		this.isOn = true;

	}

	@Override
	public void switchOff() {
		this.isOn = false;

	}
	
	@Override
	public boolean isOn() {
		return this.isOn;
	}

	@Override
	public double getWindSpeed() {
		return this.windSpeed;
	}

	@Override
	public double getPower() {
		return this.powerOutput_W;
	}

	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.wsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}
}
