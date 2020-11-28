package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class GasolineGeneratorConnector extends AbstractConnector implements GasolineGeneratorControlCI {

	@Override
	public double getMax() throws Exception {
		return ((GasolineGeneratorControlCI)this.offering).getMax();
	}

	@Override
	public double getCurrentState() throws Exception {
		return ((GasolineGeneratorControlCI)this.offering).getCurrentState();

	}

	@Override
	public double fill(double liter) throws Exception {
		return ((GasolineGeneratorControlCI)this.offering).fill(liter);

	}

}
