package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface WindTurbineControlCI extends RequiredCI{
	
	public void switchOn() throws Exception;
	
	public void switchOff() throws Exception;
	
	public boolean isOn()  throws Exception;
	
	public double getWindSpeed() throws Exception;
	
	public double getPower() throws Exception;
}
