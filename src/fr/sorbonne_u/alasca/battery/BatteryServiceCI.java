package fr.sorbonne_u.alasca.battery;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface BatteryServiceCI extends OfferedCI {
	double getMax() throws Exception; // how many kw/h the battery can contains
	double getCurrentState() throws Exception; // how many hw/h the battery have
	
	// fill and drain ? (mb for RequiredCI)
}
