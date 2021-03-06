package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface HeatingServiceCI extends OfferedCI {
public boolean getState() throws Exception;
	
	public void switchOn() throws Exception;
	
	public void switchOff() throws Exception;
	
	public void scheduleOn() throws Exception; 
	
	public void scheduleOff() throws Exception;
	
	public void resume() throws Exception;
	
	public double getHomeTemp() throws Exception;
	
	public void setTemp1(double temp) throws Exception;
	
	public void setTemp2(double temp) throws Exception;
	
	public void setTimeBand1(int deb, int fin) throws Exception;
	
	public void setTimeBand2(int deb, int fin) throws Exception;
}
