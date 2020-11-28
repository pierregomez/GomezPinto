package fr.sorbonne_u.alasca.windTurbine;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface WindTurbineControlCI extends RequiredCI{
	
	public void switchOn();
	
	public void switchOff();
	
	public boolean isOn();
	
	public double getWindSpeed();
	
	public double getPower();
}
