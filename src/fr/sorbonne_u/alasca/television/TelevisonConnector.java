package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.connectors.AbstractConnector;

public class TelevisonConnector extends AbstractConnector implements TelevisionControlCI {

	@Override
	public boolean getState() {
		return ((TelevisonConnector)this.offering).getState();
	}

}
