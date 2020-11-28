package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {GasolineGeneratorServiceCI.class})
public class GasolineGenerator  extends AbstractComponent {
	private final double max;	
	private double current;
	
	public static final String CSIP_URI = "GasolineGenerator_CSIP_URI";
	protected GasolineGeneratorServiceInboundPort csip;
	
	protected GasolineGenerator(double max) throws Exception {
		super(1,0);
		this.csip = new GasolineGeneratorServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
		
		this.max = max;
		this.current = max;
	}
	
	public double getMax() {
		return max;
	}

	public double getCurrentState() {
		return current;
	}
	
	public double fill(double liter) {
		if(current + liter < max) {
			current += liter;
			return 0;
		}
		current = max;
		return (current + liter) - max;
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.csip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}
}
