package fr.sorbonne_u.alasca.windTurbine;


public interface WindTurbineInterface{
	
	public void switchOn() throws Exception;
	
	public void switchOff() throws Exception;
	
	public boolean isOn()  throws Exception;
	
	public double getWindSpeed() throws Exception;
	
	public double getPower() throws Exception;
}
