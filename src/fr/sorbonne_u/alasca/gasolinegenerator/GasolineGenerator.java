package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {GasolineGeneratorServiceCI.class})
public class GasolineGenerator  extends AbstractComponent implements GasolineGeneratorInterface{
	private final double capacity_Wh;
	private double powerLeft_Wh;
	private double powerOutput_W;
	private boolean isOn;
	public enum Mode {LOW,HIGH};
	private Mode mode;
	
	protected GasolineGeneratorServiceInboundPort gsip;
	
	protected GasolineGenerator(String uri, double capacity_Wh) throws Exception {
		super(uri,1,0);
		this.gsip = new GasolineGeneratorServiceInboundPort(URIs.GENERATOR_INBOUND_PORT_URI, this);
		this.gsip.publishPort();
		
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
	
//	@Override
//	public void setHigh() {
//		this.mode = Mode.HIGH;
//		this.powerOutput_W = 3000;
//		
//	}
	
	@Override
	public void setMode(Mode m) {
		this.mode = m;
	}
	
	@Override
	public void setPowerOutput_W(int w) {
		this.powerOutput_W = w;
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
	public Mode getMode() throws Exception {
		return this.mode;
		
	}
	@Override
	public void switchOff() throws Exception {
		this.isOn = false;
	}
	
	@Override
	public void switchOn() throws Exception {
		this.isOn = true;
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.gsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}





}
