package fr.sorbonne_u.alasca.fridge;

public interface FridgeInterface{
	
	double emergencyDegree() throws Exception; // [0, 1] 0: not urgent, 1: critical
	void switchOff() throws Exception;
	void switchOn() throws Exception;
	boolean getCurrentState() throws Exception;
}
