package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface HeatingServiceCI extends OfferedCI {
	void scheduleOn(int millsec) throws Exception;
	void scheduleOff(int millsec) throws Exception;
	boolean getState() throws Exception;
}
