package fr.sorbonne_u.alasca.main;

import fr.sorbonne_u.alasca.battery.Battery;
import fr.sorbonne_u.alasca.controller.HomeController;
import fr.sorbonne_u.alasca.energyCounter.EnergyCounter;
import fr.sorbonne_u.alasca.fridge.Fridge;
import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGenerator;
import fr.sorbonne_u.alasca.heating.Heating;
import fr.sorbonne_u.alasca.television.Television;
import fr.sorbonne_u.alasca.utils.URIs;
import fr.sorbonne_u.alasca.windTurbine.WindTurbine;
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
						URIs.FRIDGE_URI
		});
		
		AbstractComponent.createComponent(Battery.class.getCanonicalName(),
				new Object[] {
						URIs.BATTERY_URI,
						5000.0
		});
		
		AbstractComponent.createComponent(EnergyCounter.class.getCanonicalName(),
				new Object[] {
						URIs.ENERGY_COUNTER_URI
		});
		
		AbstractComponent.createComponent(GasolineGenerator.class.getCanonicalName(),
				new Object[] {
						URIs.GENERATOR_URI,
						5000.0
		});
		
		AbstractComponent.createComponent(Heating.class.getCanonicalName(),
				new Object[] {
						URIs.HEATING_URI
		});
		
		AbstractComponent.createComponent(Television.class.getCanonicalName(),
				new Object[] {
						URIs.TV_URI
		});
		
		AbstractComponent.createComponent(WindTurbine.class.getCanonicalName(),
				new Object[] {
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
			c.startStandardLifeCycle(5000L);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
