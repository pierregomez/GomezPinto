package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

@OfferedInterfaces(offered = {TelevisionServiceCI.class})
public class Television extends AbstractComponent implements TelevisionServiceCI{

	public static final String CSIP_URI = "Television_CSIP_URI";
	protected TelevisionServiceInboundPort csip;
	private boolean isOn;
	
	protected Television(double max) throws Exception {
		super(1,0);
		this.csip = new TelevisionServiceInboundPort(CSIP_URI, this);
		this.csip.publishPort();
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
			this.csip.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}



}
