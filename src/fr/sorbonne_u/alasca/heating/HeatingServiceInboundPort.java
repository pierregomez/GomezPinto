package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class HeatingServiceInboundPort extends AbstractInboundPort implements HeatingServiceCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 775935286747651168L;

	public HeatingServiceInboundPort(ComponentI owner) throws Exception {
		super(HeatingServiceCI.class, owner);
	}
	
	public HeatingServiceInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, HeatingServiceCI.class, owner);
	}

	@Override
	public void scheduleOn(int millsec) throws Exception {
		this.getOwner().handleRequestSync(
				c -> {((Heating)c).scheduleOn(); return 0;});		
	}

	@Override
	public void scheduleOff(int millsec) throws Exception {
		this.getOwner().handleRequestSync(
				c -> {((Heating)c).scheduleOff(); return 0;});		
	}

	@Override
	public boolean getState() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Heating)c).getState());
	}


}
