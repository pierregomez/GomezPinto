package fr.sorbonne_u.alasca.fridge;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {FridgeServiceCI.class})
public class Fridge  extends AbstractComponent{
	public static final String CSIP_URI = "port-fridge-in-uri";
	protected FridgeServiceInboundPort csip;
	
	private boolean isOn;
	
	protected Fridge(String uri) throws Exception {
		super(uri,1,0);
		this.csip = new FridgeServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
		
		this.isOn = false;

	}
	
	public void switchOff() {
		isOn = false;
	}
	
	public void switchOn () {
		isOn = true;
	}
	
	public boolean getCurrentState() {
		return isOn;
	}
	
	public double emergencyDegree() {
		return 0; // TODO
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
