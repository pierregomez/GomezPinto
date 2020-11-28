package fr.sorbonne_u.alasca.television;

import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface TelevisionControlCI extends RequiredCI{
	
	public boolean getState() throws Exception;
}
