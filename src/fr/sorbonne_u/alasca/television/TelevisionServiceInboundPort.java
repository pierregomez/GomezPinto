package fr.sorbonne_u.alasca.television;


import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class TelevisionServiceInboundPort extends AbstractInboundPort implements TelevisionServiceCI {

	/**
	 * 
	 */

	private static final long serialVersionUID = -117487331788155645L;

	public TelevisionServiceInboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, TelevisionServiceCI.class, owner);
	}

	public TelevisionServiceInboundPort(ComponentI owner)
			throws Exception {
		super(TelevisionServiceCI.class, owner);
	}


	@Override
	public boolean getState() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
