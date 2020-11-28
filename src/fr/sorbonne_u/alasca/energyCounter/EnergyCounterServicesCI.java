package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface EnergyCounterServicesCI extends OfferedCI {
	
	public double getInstantConsumption() throws Exception;
}
