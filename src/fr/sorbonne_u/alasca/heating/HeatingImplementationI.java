package fr.sorbonne_u.alasca.heating;

public interface HeatingImplementationI {
	
	public boolean getState();
	
	public void scheduleOn();
	
	public void scheduleOff();
	
	public void resume();
	
	public void setTemp1(double temp);
	
	public void setTemp2(double temp);
	
	public void setTimeBand1(int deb, int fin);
	
	public void setTimeBand2(int deb, int fin);
}
