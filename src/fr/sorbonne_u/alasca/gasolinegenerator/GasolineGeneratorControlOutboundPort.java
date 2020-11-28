package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGenerator.Mode;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class GasolineGeneratorControlOutboundPort extends AbstractOutboundPort implements GasolineGeneratorControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GasolineGeneratorControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, GasolineGeneratorControlCI.class, owner);
	}

	@Override
	public double getCapacity() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getCapacity();
	}

	@Override
	public double getPowerLeft() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getPowerLeft();
	}

	@Override
	public boolean isOn() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).isOn();
	}

	@Override
	public double getPowerOutput() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getPowerOutput();
	}

	@Override
	public void switchOff() throws Exception {
		((GasolineGeneratorControlCI)this.getConnector()).switchOff();
		
	}

	@Override
	public void switchOn() throws Exception {
		((GasolineGeneratorControlCI)this.getConnector()).switchOn();
		
	}

	@Override
	public void setHigh() throws Exception {
		((GasolineGeneratorControlCI)this.getConnector()).setHigh();
		
	}

	@Override
	public void setLow() throws Exception {
		((GasolineGeneratorControlCI)this.getConnector()).setLow();
		
	}

	@Override
	public Mode getMode() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getMode();
	}

	@Override
	public void consumeGas() throws Exception {
		((GasolineGeneratorControlCI)this.getConnector()).consumeGas();
		
	}



}
