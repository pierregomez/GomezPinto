package fr.sorbonne_u.alasca.Controler;

import fr.sorbonne_u.alasca.fridge.FridgeConnector;
import fr.sorbonne_u.alasca.fridge.FridgeControlCI;
import fr.sorbonne_u.alasca.fridge.FridgeControlOutboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import fr.sorbonne_u.components.exceptions.ComponentStartException;

@RequiredInterfaces(required = {FridgeControlCI.class})
public class HomeControler extends AbstractComponent implements HomeControlerInterface {
	private  FridgeControlOutboundPort fridgeOutboundPort;
	private String fridgeInboundPortURI;

	protected HomeControler(
			String reflectionInboundPortURI,
			String fridgeOutboundPortURI,
            String fridgeInboundPortURI
			) throws Exception {
		super(reflectionInboundPortURI, 1, 0);
		this.fridgeInboundPortURI = fridgeInboundPortURI;
		
		this.fridgeOutboundPort = new FridgeControlOutboundPort(fridgeOutboundPortURI,this);
        this.fridgeOutboundPort.publishPort();
	}
	
	@Override
    public void start() throws ComponentStartException{
        super.start();
        try {
            this.doPortConnection(
                    this.fridgeOutboundPort.getPortURI(),
                    this.fridgeInboundPortURI,
                    FridgeConnector.class.getCanonicalName());
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
//            this.tvOutboundPort.unpublishPort();
            this.fridgeOutboundPort.unpublishPort();
//            this.windTurbineOutboundPort.unpublishPort();
//            this.batteryOutboundPort.unpublishPort();
        }catch(Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }

    @Override
    public void shutdownNow() throws ComponentShutdownException {
        try {
//          this.tvOutboundPort.unpublishPort();
          this.fridgeOutboundPort.unpublishPort();
//          this.windTurbineOutboundPort.unpublishPort();
//          this.batteryOutboundPort.unpublishPort();
        }catch(Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdownNow();
    }

    @Override
    public void finalise() throws Exception{
//        this.doPortDisconnection(this.tvOutboundPort.getPortURI());
        this.doPortDisconnection(this.fridgeOutboundPort.getPortURI());
//        this.doPortDisconnection(this.windTurbineOutboundPort.getPortURI());
//        this.doPortDisconnection(this.batteryOutboundPort.getPortURI());
        super.finalise();
    }

}
