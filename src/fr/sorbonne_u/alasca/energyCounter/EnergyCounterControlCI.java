package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface EnergyCounterControlCI extends RequiredCI {
	
	public double getInstantConsumption() throws Exception;
}
