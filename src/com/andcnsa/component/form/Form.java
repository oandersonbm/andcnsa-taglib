package com.andcnsa.component.form;

import java.io.IOException;

import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class Form extends UIForm{

	//private enum Propriedades{}
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context);
		out.write("<form id='"+clientId+"' name='"+clientId+"' method='post' enctype='utf-8' autocomplete='off'>");	
		out.write("<input type='hidden' id='"+clientId+"' name='"+clientId+"' value='"+clientId+"'>");		
	}
}
