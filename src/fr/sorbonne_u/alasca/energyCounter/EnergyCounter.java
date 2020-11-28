package fr.sorbonne_u.alasca.energyCounter;

import fr.sorbonne_u.components.AbstractComponent;

public class EnergyCounter extends AbstractComponent {

	public EnergyCounter() {
		super(1,0);
	}

	public EnergyCounter(String reflectionInboundPortURI, int nbThreads, int nbSchedulableThreads) {
		super(reflectionInboundPortURI, nbThreads, nbSchedulableThreads);
		// TODO Auto-generated constructor stub
	}

}
