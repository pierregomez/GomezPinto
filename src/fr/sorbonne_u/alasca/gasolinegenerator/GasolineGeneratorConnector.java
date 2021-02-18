package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGenerator.Mode;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class GasolineGeneratorConnector extends AbstractConnector implements GasolineGeneratorControlCI {

	@Override
	public double getCapacity() throws Exception {
		return ((GasolineGeneratorServiceCI)this.offering).getCapacity();
	}

	@Override
	public double getPowerLeft() throws Exception {
		return ((GasolineGeneratorServiceCI)this.offering).getPowerLeft();
	}

	@Override
	public boolean isOn() throws Exception {
		return ((GasolineGeneratorServiceCI)this.offering).isOn();
	}

	@Override
	public double getPowerOutput() throws Exception {
		return ((GasolineGeneratorServiceCI)this.offering).getPowerOutput();
	}

	@Override
	public void switchOff() throws Exception {
		((GasolineGeneratorServiceCI)this.offering).switchOff();
	}

	@Override
	public void switchOn() throws Exception {
		((GasolineGeneratorServiceCI)this.offering).switchOn();
		
	}

	@Override
	public void setHigh() throws Exception {
		((GasolineGeneratorServiceCI)this.offering).setMode(Mode.HIGH);
		((GasolineGeneratorServiceCI)this.offering).setPowerOutput_W(3000);
		
	}

	@Override
	public void setLow() throws Exception {
		((GasolineGeneratorServiceCI)this.offering).setLow();
		
	}

	@Override
	public Mode getMode() throws Exception {
		return ((GasolineGeneratorServiceCI)this.offering).getMode();
	}

	@Override
	public void consumeGas() throws Exception {
		((GasolineGeneratorServiceCI)this.offering).consumeGas();
		
	}



}
