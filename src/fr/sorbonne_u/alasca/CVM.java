package fr.sorbonne_u.alasca;

import fr.sorbonne_u.alasca.controller.HomeController;
import fr.sorbonne_u.alasca.fridge.Fridge;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.cvm.AbstractCVM;

public class CVM extends AbstractCVM {

	public CVM() throws Exception {
		super();
	}

	

	@Override
	public void deploy() throws Exception {
		
		AbstractComponent.createComponent(Fridge.class.getCanonicalName(),
				new Object[] {
						URIs.FRIDGE_URI,
						URIs.BATTERY_URI,
						URIs.ENERGY_COUNTER_URI,
						URIs.GENERATOR_URI,
						URIs.HEATING_URI,
						URIs.TV_URI,
						URIs.WINDTURBINE_URI
		});
		AbstractComponent.createComponent(HomeController.class.getCanonicalName(),
				new Object[] {
						URIs.CONTROLLER_URI,
						URIs.FRIDGE_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.FRIDGE_INBOUND_PORT_URI,
						URIs.BATTERY_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.BATTERY_INBOUND_PORT_URI,
						URIs.ENERGY_COUNTER_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.ENERGY_COUNTER_INBOUND_PORT_URI,
						URIs.GENERATOR_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.GENERATOR_INBOUND_PORT_URI,
						URIs.HEATING_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.HEATING_INBOUND_PORT_URI,
						URIs.TV_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.TV_INBOUND_PORT_URI,
						URIs.WINDTURBINE_CONTROLLER_OUTBOUND_PORT_URI,
						URIs.WINDTURBINE_INBOUND_PORT_URI
				});
		
		super.deploy();
	}



	public static void main(String[] args) {
		try {
			CVM c = new CVM();
			//appelle deploy pouis start puis execute puis finilize puis shutdown
			c.startStandardLifeCycle(1000L);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
