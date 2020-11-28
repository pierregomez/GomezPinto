package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface HeatingControlCI extends RequiredCI{
	
	public boolean getState() throws Exception;
	
	public void scheduleOn() throws Exception; 
	
	public void scheduleOff() throws Exception;
	
	public void resume() throws Exception;
	
	public void setTemp1(double temp) throws Exception;
	
	public void setTemp2(double temp) throws Exception;
	
	public void setTimeBand1(int deb, int fin) throws Exception;
	
	public void setTimeBand2(int deb, int fin) throws Exception;
}
