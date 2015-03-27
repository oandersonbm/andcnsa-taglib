package com.andcnsa.component.util;

import java.net.URI;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Link {
	public static Object getOutcomeLink(FacesContext context, String link){
		Object retorno = null;
		try {
			ExternalContext ext = context.getExternalContext();
			URI uri = new URI(ext.getRequestScheme(), null, ext.getRequestServerName(), ext.getRequestServerPort(), ext.getRequestContextPath(), null, null);
			retorno = uri.toASCIIString()+"/"+link;
		} catch (Exception e) {
			
		}
		return retorno;
	}
}
