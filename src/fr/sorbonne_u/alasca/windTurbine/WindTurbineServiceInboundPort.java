package fr.sorbonne_u.alasca.windTurbine;


import fr.sorbonne_u.alasca.fridge.Fridge;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class WindTurbineServiceInboundPort extends AbstractInboundPort implements WindTurbineServiceCI {

	/**
	 * 
	 */

	private static final long serialVersionUID = -117487331788155645L;

	public WindTurbineServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, WindTurbineServiceCI.class, owner);
	}

	public WindTurbineServiceInboundPort(ComponentI owner)
			throws Exception {
		super(WindTurbineServiceCI.class, owner);
	}


	@Override
	public void switchOn() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((WindTurbine)this.getServiceOwner()).switchOff();
                        return null;
                    }
                }) ;		
	}

	@Override
	public void switchOff() throws Exception{
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
	public boolean isOn() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((WindTurbine)c).isOn());
	}

	@Override
	public double getWindSpeed() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((WindTurbine)c).getWindSpeed());
	}

	@Override
	public double getPower() throws Exception{
		return this.getOwner().handleRequestSync(
				c -> ((WindTurbine)c).getPower());
	}

}
