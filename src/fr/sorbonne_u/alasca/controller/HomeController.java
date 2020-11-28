package fr.sorbonne_u.alasca.controller;

import fr.sorbonne_u.alasca.battery.BatteryConnector;
import fr.sorbonne_u.alasca.battery.BatteryControlOutboundPort;
import fr.sorbonne_u.alasca.energyCounter.EnergyCounterConnector;
import fr.sorbonne_u.alasca.energyCounter.EnergyCounterControlOutboundPort;
import fr.sorbonne_u.alasca.fridge.FridgeConnector;
import fr.sorbonne_u.alasca.fridge.FridgeControlCI;
import fr.sorbonne_u.alasca.fridge.FridgeControlOutboundPort;
import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGeneratorConnector;
import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGeneratorControlOutboundPort;
import fr.sorbonne_u.alasca.heating.HeatingConnector;
import fr.sorbonne_u.alasca.heating.HeatingControlOutboundPort;
import fr.sorbonne_u.alasca.television.TelevisionControlOutboundPort;
import fr.sorbonne_u.alasca.television.TelevisonConnector;
import fr.sorbonne_u.alasca.windTurbine.WindTurbineConnector;
import fr.sorbonne_u.alasca.windTurbine.WindTurbineControlOutboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import fr.sorbonne_u.components.exceptions.ComponentStartException;

@RequiredInterfaces(required = {FridgeControlCI.class})
public class HomeController extends AbstractComponent{
	
	private  FridgeControlOutboundPort fridgeOutboundPort;
	private  BatteryControlOutboundPort batteryOutboundPort;
	private  EnergyCounterControlOutboundPort energyCounterOutboundPort;
	private  GasolineGeneratorControlOutboundPort generatorOutboundPort;
	private  HeatingControlOutboundPort heatingOutboundPort;
	private  TelevisionControlOutboundPort tvOutboundPort;
	private  WindTurbineControlOutboundPort windturbineOutboundPort;
	
	private String fridgeInboundPortURI;
	private String batteryInboundPortURI;
	private String energyCounterInboundPortURI;
	private String generatorInboundPortURI;
	private String heatingInboundPortURI;
	private String tvInboundPortURI;
	private String windturbineInboundPortURI;

	protected HomeController(
			String reflectionInboundPortURI,
			String fridgeControlOutboundPortURI,
            String fridgeInboundPortURI,
            String batteryControlOutboundPortURI,
            String batteryInboundPortURI,
            String energyCounterControlOutboundPortURI,
            String energyCounterInboundPortURI,
            String generatorControlOutboundPortURI,
            String generatorInboundPortURI,
            String heatingControlOutboundPortURI,
            String heatingInboundPortURI,
            String tvControlOutboundPortURI,
            String tvInboundPortURI,
            String windturbineControlOutboundPortURI,
            String windturbineInboundPortURI
            
			) throws Exception {
		super(reflectionInboundPortURI, 1, 0);
		
		this.fridgeInboundPortURI = fridgeInboundPortURI;
		this.fridgeOutboundPort = new FridgeControlOutboundPort(fridgeControlOutboundPortURI,this);
        this.fridgeOutboundPort.publishPort();
        
        this.batteryInboundPortURI = batteryInboundPortURI;
		this.batteryOutboundPort = new BatteryControlOutboundPort(batteryControlOutboundPortURI,this);
        this.batteryOutboundPort.publishPort();
        
        this.energyCounterInboundPortURI = energyCounterInboundPortURI;
		this.energyCounterOutboundPort = new EnergyCounterControlOutboundPort(energyCounterControlOutboundPortURI,this);
        this.energyCounterOutboundPort.publishPort();
        
        this.generatorInboundPortURI = generatorInboundPortURI;
		this.generatorOutboundPort = new GasolineGeneratorControlOutboundPort(generatorControlOutboundPortURI,this);
        this.generatorOutboundPort.publishPort();
        
        this.heatingInboundPortURI = heatingInboundPortURI;
		this.heatingOutboundPort = new HeatingControlOutboundPort(heatingControlOutboundPortURI,this);
        this.heatingOutboundPort.publishPort();
        
        this.tvInboundPortURI = tvInboundPortURI;
		this.tvOutboundPort = new TelevisionControlOutboundPort(tvControlOutboundPortURI,this);
        this.tvOutboundPort.publishPort();
        
        this.windturbineInboundPortURI = windturbineInboundPortURI;
		this.windturbineOutboundPort = new WindTurbineControlOutboundPort(windturbineControlOutboundPortURI,this);
        this.windturbineOutboundPort.publishPort();
        
	}
	
	@Override
    public void start() throws ComponentStartException{
        super.start();
        try {
            this.doPortConnection(
                    this.fridgeOutboundPort.getPortURI(),
                    this.fridgeInboundPortURI,
                    FridgeConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.batteryOutboundPort.getPortURI(),
                    this.batteryInboundPortURI,
                    BatteryConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.energyCounterOutboundPort.getPortURI(),
                    this.energyCounterInboundPortURI,
                    EnergyCounterConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.generatorOutboundPort.getPortURI(),
                    this.generatorInboundPortURI,
                    GasolineGeneratorConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.heatingOutboundPort.getPortURI(),
                    this.heatingInboundPortURI,
                    HeatingConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.tvOutboundPort.getPortURI(),
                    this.tvInboundPortURI,
                    TelevisonConnector.class.getCanonicalName());
            this.doPortConnection(
                    this.windturbineOutboundPort.getPortURI(),
                    this.windturbineInboundPortURI,
                    WindTurbineConnector.class.getCanonicalName());
        }catch(Exception e) {
            throw new ComponentStartException(e);
        }
    }	
	
	public void execute() throws Exception{
        super.execute();
        System.out.println("is the fidge on ? :  " + this.fridgeOutboundPort.getCurrentState());
        this.fridgeOutboundPort.switchOn();
        System.out.println("is the fidge on ? :  " + this.fridgeOutboundPort.getCurrentState());
	}
	
	@Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.tvOutboundPort.unpublishPort();
            this.fridgeOutboundPort.unpublishPort();
            this.generatorOutboundPort.unpublishPort();
            this.heatingOutboundPort.unpublishPort();
            this.energyCounterOutboundPort.unpublishPort();
            this.windturbineOutboundPort.unpublishPort();
            this.batteryOutboundPort.unpublishPort();
        }catch(Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }

    @Override
    public void shutdownNow() throws ComponentShutdownException {
        try {
          this.tvOutboundPort.unpublishPort();
          this.fridgeOutboundPort.unpublishPort();
          this.generatorOutboundPort.unpublishPort();
          this.heatingOutboundPort.unpublishPort();
          this.energyCounterOutboundPort.unpublishPort();
          this.windturbineOutboundPort.unpublishPort();
          this.batteryOutboundPort.unpublishPort();
        }catch(Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdownNow();
    }

    @Override
    public void finalise() throws Exception{
        this.doPortDisconnection(this.tvOutboundPort.getPortURI());
        this.doPortDisconnection(this.fridgeOutboundPort.getPortURI());
        this.doPortDisconnection(this.generatorOutboundPort.getPortURI());
        this.doPortDisconnection(this.heatingOutboundPort.getPortURI());
        this.doPortDisconnection(this.energyCounterOutboundPort.getPortURI());
        this.doPortDisconnection(this.windturbineOutboundPort.getPortURI());
        this.doPortDisconnection(this.batteryOutboundPort.getPortURI());
        super.finalise();
    }

}
