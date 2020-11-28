package fr.sorbonne_u.alasca.gasolinegenerator;


import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class GasolineGeneratorServiceInboundPort extends AbstractInboundPort implements GasolineGeneratorServiceCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3875018977842718750L;

	public GasolineGeneratorServiceInboundPort(ComponentI owner)
			throws Exception {
		super(GasolineGeneratorServiceCI.class, owner);
	}
	
	public GasolineGeneratorServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, GasolineGeneratorServiceCI.class, owner);
	}

	@Override
	public double getMax() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getMax());
	}

	@Override
	public double getCurrentState() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getCurrentState());
	}

	@Override
	public double fill(double liter) throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).fill(liter));
	}

}
