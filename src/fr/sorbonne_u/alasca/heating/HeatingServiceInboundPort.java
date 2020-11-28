package fr.sorbonne_u.alasca.heating;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class HeatingServiceInboundPort extends AbstractInboundPort implements HeatingServiceCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 775935286747651168L;

	public HeatingServiceInboundPort(ComponentI owner) throws Exception {
		super(HeatingServiceCI.class, owner);
	}
	
	public HeatingServiceInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, HeatingServiceCI.class, owner);
	}

	@Override
	public boolean getState() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Heating)c).getState());
	}

	@Override
	public void scheduleOn() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).scheduleOn();
                        return null;
                    }
                }) ;		
	}

	@Override
	public void scheduleOff() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).scheduleOff();
                        return null;
                    }
                }) ;			
	}

	@Override
	public void resume() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).resume();
                        return null;
                    }
                }) ;			
	}

	@Override
	public void setTemp1(double temp) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).setTemp1(temp);
                        return null;
                    }
                }) ;			
	}

	@Override
	public void setTemp2(double temp) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).setTemp2(temp);
                        return null;
                    }
                }) ;			
	}

	@Override
	public void setTimeBand1(int deb, int fin) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).setTimeBand1(deb, fin);
                        return null;
                    }
                }) ;			
	}

	@Override
	public void setTimeBand2(int deb, int fin) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).setTimeBand2(deb, fin);
                        return null;
                    }
                });
	}

	@Override
	public void switchOn() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).switchOn();
                        return null;
                    }
                }) ;
		
	}

	@Override
	public void switchOff() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((Heating)this.getServiceOwner()).switchOff();
                        return null;
                    }
                }) ;
		
	}

	@Override
	public double getHomeTemp() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((Heating)c).getHomeTemp());
	}



}
