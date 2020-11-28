package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class TelevisonConnector extends AbstractConnector implements TelevisionControlCI {

	@Override
	public boolean getState() throws Exception {
		return ((TelevisionServiceCI)this.offering).getState();
	}

}
