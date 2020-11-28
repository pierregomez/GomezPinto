package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.alasca.URIs;
import fr.sorbonne_u.components.AbstractComponent;

public class WindTurbine extends AbstractComponent implements WindTurbineServiceCI {
	
	protected WindTurbineServiceInboundPort wsip;
	
	private boolean isOn;
	private double windSpeed;
	private double power;
	

	protected WindTurbine(String uri) throws Exception {
		super(uri,1,0);
		this.wsip = new WindTurbineServiceInboundPort(URIs.WINDTURBINE_INBOUND_PORT_URI, this);
		this.wsip.publishPort();
		
		this.isOn = false;
		this.windSpeed = 0;
		this.power = 0;

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
		return this.power;
	}


}
