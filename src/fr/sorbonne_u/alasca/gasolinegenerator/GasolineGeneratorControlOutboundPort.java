package fr.sorbonne_u.alasca.gasolinegenerator;

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
	public double getMax() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getMax();
	}

	@Override
	public double getCurrentState() throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).getCurrentState();
	}

	@Override
	public double fill(double liter) throws Exception {
		return ((GasolineGeneratorControlCI)this.getConnector()).fill(liter);
	}

}
