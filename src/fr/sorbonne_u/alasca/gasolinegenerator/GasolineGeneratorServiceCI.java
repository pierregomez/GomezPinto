package fr.sorbonne_u.alasca.gasolinegenerator;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface GasolineGeneratorServiceCI extends OfferedCI {
	double getMax() throws Exception; // how many liter of fuel the generator can give contains
	double currentState() throws Exception; // how many liter of fuel the generator have
	double fill(double liter) throws Exception; // fill the tank of the generator return the excess
	
	// on and off ? (mb for RequiredCI)
}
