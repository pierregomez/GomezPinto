package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class HeatingConnector extends AbstractConnector implements HeatingControlCI {

	@Override
	public boolean getState() throws Exception {
		return ((HeatingServiceCI)this.offering).getState();
	}

	@Override
	public void scheduleOn() throws Exception {
		((HeatingServiceCI)this.offering).scheduleOn();

	}

	@Override
	public void scheduleOff() throws Exception {
		((HeatingServiceCI)this.offering).scheduleOff();

	}

	@Override
	public void resume() throws Exception {
		((HeatingServiceCI)this.offering).resume();

	}

	@Override
	public void setTemp1(double temp) throws Exception {
		((HeatingServiceCI)this.offering).setTemp1(temp);

	}

	@Override
	public void setTemp2(double temp) throws Exception {
		((HeatingServiceCI)this.offering).setTemp2(temp);

	}

	@Override
	public void setTimeBand1(int deb, int fin) throws Exception {
		((HeatingServiceCI)this.offering).setTimeBand1(deb, fin);

	}

	@Override
	public void setTimeBand2(int deb, int fin) throws Exception {
		((HeatingServiceCI)this.offering).setTimeBand2(deb, fin);

	}

	@Override
	public void switchOn() throws Exception {
		((HeatingServiceCI)this.offering).switchOn();
		
	}

	@Override
	public void switchOff() throws Exception {
		((HeatingServiceCI)this.offering).switchOff();
		
	}

	@Override
	public double getHomeTemp() throws Exception {
		return ((HeatingServiceCI)this.offering).getHomeTemp();
	}

}
