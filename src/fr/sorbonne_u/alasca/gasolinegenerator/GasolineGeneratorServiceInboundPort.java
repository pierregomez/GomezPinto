package fr.sorbonne_u.alasca.gasolinegenerator;


import fr.sorbonne_u.alasca.gasolinegenerator.GasolineGenerator.Mode;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class GasolineGeneratorServiceInboundPort extends AbstractInboundPort implements GasolineGeneratorServiceCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3875018977842718750L;

	public GasolineGeneratorServiceInboundPort(ComponentI owner)
			throws Exception {
		super(GasolineGeneratorServiceCI.class, owner);
	}
	
	public GasolineGeneratorServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, GasolineGeneratorServiceCI.class, owner);
	}

	@Override
	public double getCapacity() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getCapacity());
	}

	@Override
	public double getPowerLeft() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getPowerLeft());
	}

	@Override
	public boolean isOn() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).isOn());
	}

	@Override
	public double getPowerOutput() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getPowerOutput());
	}

//	@Override
//	public void setHigh() throws Exception {
//		this.getOwner().handleRequestSync(
//				new AbstractComponent.AbstractService<Void>() {
//                    @Override
//                    public Void call() throws Exception {
//                        ((GasolineGenerator)this.getServiceOwner()).setHigh();
//                        return null;
//                    }
//                }) ;
//		
//	}
	
	@Override
	public void setMode(Mode m) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((GasolineGenerator)this.getServiceOwner()).setMode(m);
                        return null;
                    }
                }) ;
		
	}
	
	@Override
	public void setPowerOutput_W(int w) throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((GasolineGenerator)this.getServiceOwner()).setPowerOutput_W(w);
                        return null;
                    }
                }) ;
		
	}

	@Override
	public void setLow() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((GasolineGenerator)this.getServiceOwner()).setLow();
                        return null;
                    }
                }) ;
		
	}

	@Override
	public void consumeGas() throws Exception {
		this.getOwner().handleRequestSync(
				new AbstractComponent.AbstractService<Void>() {
                    @Override
                    public Void call() throws Exception {
                        ((GasolineGenerator)this.getServiceOwner()).consumeGas();
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
                        ((GasolineGenerator)this.getServiceOwner()).switchOff();
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
                        ((GasolineGenerator)this.getServiceOwner()).switchOn();
                        return null;
                    }
                }) ;
		
	}

	@Override
	public Mode getMode() throws Exception {
		return this.getOwner().handleRequestSync(
				c -> ((GasolineGenerator)c).getMode());
	}

	

}
