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
import fr.sorbonne_u.components.cvm.AbstractDistributedCVM;

public class DistributedCVM extends AbstractDistributedCVM{

    public DistributedCVM(String[] args,int xLayout, int yLayout) throws Exception {
        super(args,xLayout,yLayout);
    }

    
    @Override
    public void initialise() throws Exception{
        super.initialise();
    }

    public static void	main(String[] args){
        try {
            DistributedCVM dc  = new DistributedCVM(args, 2, 5);
            dc.startStandardLifeCycle(5000L);
            Thread.sleep(3000L);
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void instantiateAndPublish() throws Exception{
    	
        if(thisJVMURI.equals(URIs.JVM_CONTROLLER_URI)) {
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
    						URIs.WINDTURBINE_INBOUND_PORT_URI});

            this.toggleLogging(URIs.CONTROLLER_URI);
            this.toggleTracing(URIs.CONTROLLER_URI);

        }
        else if (thisJVMURI.equals(URIs.JVM_ENERGY_COUNTER_URI)) {
            AbstractComponent.createComponent(EnergyCounter.class.getCanonicalName(),
                    new Object[] {
                            URIs.ENERGY_COUNTER_URI});

            this.toggleLogging(URIs.ENERGY_COUNTER_URI);
            this.toggleTracing(URIs.ENERGY_COUNTER_URI);
        }
        else if (thisJVMURI.equals(URIs.JVM_EQUIPMENTS_URI)) {
        	AbstractComponent.createComponent(Battery.class.getCanonicalName(),
    				new Object[] {
    						URIs.BATTERY_URI,
    						5000.0
    		});
        	this.toggleLogging(URIs.BATTERY_URI);
        	this.toggleTracing(URIs.BATTERY_URI);
        	
        	AbstractComponent.createComponent(Fridge.class.getCanonicalName(),
    				new Object[] {
    						URIs.FRIDGE_URI
    		});
        	this.toggleLogging(URIs.FRIDGE_URI);
        	this.toggleTracing(URIs.FRIDGE_URI);

        	AbstractComponent.createComponent(GasolineGenerator.class.getCanonicalName(),
    				new Object[] {
    						URIs.GENERATOR_URI,
    						5000.0
    		});
            this.toggleLogging(URIs.GENERATOR_URI);
            this.toggleTracing(URIs.GENERATOR_URI);

            AbstractComponent.createComponent(Heating.class.getCanonicalName(),
    				new Object[] {
    						URIs.HEATING_URI
    		});
            this.toggleLogging(URIs.HEATING_URI);
            this.toggleTracing(URIs.HEATING_URI);
            
            AbstractComponent.createComponent(Television.class.getCanonicalName(),
    				new Object[] {
    						URIs.TV_URI
    		});
            this.toggleLogging(URIs.TV_URI);
            this.toggleTracing(URIs.TV_URI);

            AbstractComponent.createComponent(WindTurbine.class.getCanonicalName(),
    				new Object[] {
    						URIs.WINDTURBINE_URI
    		});
            this.toggleLogging(URIs.WINDTURBINE_URI);
            this.toggleTracing(URIs.WINDTURBINE_URI);
        }
        else {
            System.err.println("multi-JVM uri problems");
        }
        super.instantiateAndPublish();
    }

    @Override
    public void	interconnect() throws Exception{
        assert	this.isIntantiatedAndPublished();
        super.interconnect();
    }

    @Override
    public void start() throws Exception{
        super.start();
    }

    @Override
    public void finalise() throws Exception{
        super.finalise();
    }
}
