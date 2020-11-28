package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {HeatingServiceCI.class})
public class Heating extends AbstractComponent implements HeatingImplementationI{
	public static final String CSIP_URI = "Heating_CSIP_URI";
	protected HeatingServiceInboundPort csip;
	
	// faire la gestion du temps
	
	protected Heating() throws Exception {
		super(1,0);
		this.csip = new HeatingServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
		
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
	
	public void scheduleOn() {
		// TODO
	}
	
	public void scheduleOff() {
		// TODO
	}
	
	public boolean getState() {
		return false; // TODO
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
}
