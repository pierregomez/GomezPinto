package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface GasolineGeneratorServiceCI extends OfferedCI {
	
	public double getCapacity() throws Exception;
	
	public double getPowerLeft() throws Exception;
	
	public boolean isOn() throws Exception;
	
	public double getPowerOutput() throws Exception;
	
	public void setHigh() throws Exception;
	
	public void setLow() throws Exception;
	
	public void consumeGas() throws Exception;
}
