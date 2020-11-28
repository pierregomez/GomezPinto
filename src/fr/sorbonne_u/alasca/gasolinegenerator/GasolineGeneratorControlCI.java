package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGenerator.Mode;
import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface GasolineGeneratorControlCI extends RequiredCI {
	
	public double getCapacity() throws Exception;
	
	public double getPowerLeft() throws Exception;
	
	public boolean isOn() throws Exception;
	
	public double getPowerOutput() throws Exception;
	
	public void switchOff() throws Exception;
	
	public void switchOn() throws Exception;
	
	public void setHigh() throws Exception;
	
	public void setLow() throws Exception;
	
	public Mode getMode() throws Exception;
	
	public void consumeGas() throws Exception;
}
