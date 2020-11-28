package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.interfaces.OfferedCI;

public interface TelevisionServiceCI extends OfferedCI {
	boolean getState() throws Exception;
}
