package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class HeatingControlOutboundPort extends AbstractOutboundPort implements HeatingControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeatingControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri,HeatingControlCI.class, owner);
	}

	@Override
	public boolean getState() throws Exception {
		return ((HeatingControlCI)this.getConnector()).getState();
	}

	@Override
	public void scheduleOn() throws Exception {
		((HeatingControlCI)this.getConnector()).scheduleOn();
	}

	@Override
	public void scheduleOff() throws Exception {
		((HeatingControlCI)this.getConnector()).scheduleOff();
	}

	@Override
	public void resume() throws Exception {
		((HeatingControlCI)this.getConnector()).resume();
	}

	@Override
	public void setTemp1(double temp) throws Exception {
		((HeatingControlCI)this.getConnector()).setTemp1(temp);	}

	@Override
	public void setTemp2(double temp) throws Exception {
		((HeatingControlCI)this.getConnector()).setTemp2(temp);		
	}

	@Override
	public void setTimeBand1(int deb, int fin) throws Exception {
		((HeatingControlCI)this.getConnector()).setTimeBand1(deb, fin);		
	}

	@Override
	public void setTimeBand2(int deb, int fin) throws Exception {
		((HeatingControlCI)this.getConnector()).setTimeBand2(deb, fin);		
	}

	@Override
	public void switchOn() throws Exception {
		((HeatingControlCI)this.getConnector()).switchOn();
		
	}

	@Override
	public void switchOff() throws Exception {
		((HeatingControlCI)this.getConnector()).switchOff();
		
	}

	@Override
	public double getHomeTemp() throws Exception {
		return ((HeatingControlCI)this.getConnector()).getHomeTemp();
	}

}
