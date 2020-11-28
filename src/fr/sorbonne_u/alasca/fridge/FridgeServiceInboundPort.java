package fr.sorbonne_u.alasca.fridge;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class FridgeServiceInboundPort extends AbstractInboundPort implements FridgeServiceCI {

	private static final long serialVersionUID = -8837671057653164343L;

	
	public FridgeServiceInboundPort(ComponentI owner)
			throws Exception {
		super(FridgeServiceCI.class, owner);
	}

	public FridgeServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, FridgeServiceCI.class, owner);
	}
	
	
	@Override
	public double emergencyDegree() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Fridge)c).emergencyDegree());
	}

	@Override
	public void switchOff() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Fridge)this.getServiceOwner()).switchOff();
                        return null;
                    }
                }) ;
	}

	@Override
	public void switchOn() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Fridge)this.getServiceOwner()).switchOn();
                        return null;
                    }
                }) ;
	}

	@Override
	public boolean getCurrentState() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Fridge)c).getCurrentState());
	}

}
