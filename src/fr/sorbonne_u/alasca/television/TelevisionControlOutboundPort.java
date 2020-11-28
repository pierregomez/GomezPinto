package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class TelevisionControlOutboundPort extends AbstractOutboundPort implements TelevisionControlCI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelevisionControlOutboundPort(String uri, ComponentI owner)
			throws Exception {
		super(uri, TelevisionControlCI.class, owner);
	}

	@Override
	public boolean getState() throws Exception {
		return ((TelevisionControlCI)this.getConnector()).getState();
	}

}
