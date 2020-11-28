package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.alasca.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {HeatingServiceCI.class})
public class Heating extends AbstractComponent implements HeatingInterface{
	protected HeatingServiceInboundPort hsip;
	
	private double homeTemp;
	public boolean isOn;
	
	
	
	protected Heating(String uri) throws Exception {
		super(uri,1,0);
		this.hsip = new HeatingServiceInboundPort(URIs.HEATING_INBOUND_PORT_URI, this);
		this.hsip.publishPort();
		
		this.homeTemp = 20.0;
	}

	
	public void scheduleOn() {
		// TODO
	}
	
	public void scheduleOff() {
		// TODO
	}
	
	public boolean getState() {
		return isOn;
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTemp1(double temp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTemp2(double temp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTimeBand1(int deb, int fin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTimeBand2(int deb, int fin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.hsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}


	@Override
	public void switchOn() throws Exception {
		this.isOn = true;
		
	}


	@Override
	public void switchOff() throws Exception {
		this.isOn = false;
		
	}


	@Override
	public double getHomeTemp() throws Exception {
		return this.homeTemp;
	}
}
