package fr.sorbonne_u.alasca.fridge;

import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {FridgeServiceCI.class})
public class Fridge  extends AbstractComponent implements FridgeInterface{
	
	protected FridgeServiceInboundPort fsip;
	
	private boolean isOn;
	
	protected Fridge(String uri) throws Exception {
		super(uri,1,0);
		this.fsip = new FridgeServiceInboundPort(URIs.FRIDGE_INBOUND_PORT_URI, this);
		this.fsip.publishPort();
		
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
			this.fsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}

}
