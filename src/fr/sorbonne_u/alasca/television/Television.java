package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.alasca.URIs;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {TelevisionServiceCI.class})
public class Television extends AbstractComponent implements TelevisionInterface{

	protected TelevisionServiceInboundPort tsip;
	private boolean isOn;
	
	protected Television(String uri) throws Exception {
		super(uri,1,0);
		this.tsip = new TelevisionServiceInboundPort(URIs.TV_INBOUND_PORT_URI, this);
		this.tsip.publishPort();
		isOn = false;
		
	}
	
	/* this method is not to be accessed by the controller, so it should not appear in the offered interface*/
	protected void switchOff() {
		isOn = false;
	}
	/* this method is not to be accessed by the controller, so it should not appear in the offered interface*/
	protected void switchOn () {
		isOn = true;
	}
	
	public boolean getState() {
		return isOn;
	}
	
	@Override
	public synchronized void shutdown() throws ComponentShutdownException {
		try {
			this.tsip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}



}
