package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {GasolineGeneratorServiceCI.class})
public class GasolineGenerator  extends AbstractComponent implements GasolineGeneratorServiceCI{
	private final double capacity_Wh;
	private double powerLeft_Wh;
	private double powerOutput_W;
	private boolean isOn;
	public enum Mode {LOW,HIGH};
	private Mode mode;
	
	public static final String CSIP_URI = "GasolineGenerator_CSIP_URI";
	protected GasolineGeneratorServiceInboundPort csip;
	
	protected GasolineGenerator(double capacity_Wh) throws Exception {
		super(1,0);
		this.csip = new GasolineGeneratorServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
		
		this.capacity_Wh = capacity_Wh;
		this.powerLeft_Wh = capacity_Wh;
		this.isOn = false;
		this.mode = Mode.LOW;
	}
	
	public double getCapacity() {
		return this.capacity_Wh;
	}

	public boolean isOn() {
		return this.isOn;
	}
	
	@Override
	public double getPowerLeft() {
		return this.powerLeft_Wh;
	}
	
	@Override
	public double getPowerOutput() {
		return this.powerOutput_W;
	}
	
	@Override
	public void setHigh() {
		this.mode = Mode.HIGH;
		this.powerOutput_W = 3000;
		
	}
	
	@Override
	public void setLow() {
		this.mode = Mode.LOW;
		this.powerOutput_W = 2000;
	}
	
	@Override
	public void consumeGas() {
		if (mode == Mode.LOW) {
			this.powerLeft_Wh = this.powerLeft_Wh - 100;
		}
		else {
			this.powerLeft_Wh = this.powerLeft_Wh - 150;
		}
			
		
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
