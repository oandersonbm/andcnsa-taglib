package br.com.cadernetadigital.component.form;

import java.io.IOException;

import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class Form extends UIForm{

	private enum Propriedades{
		autocomplete
	}
	public String getAutocomplete(){
		return (String)getStateHelper().eval(Propriedades.autocomplete, "off");
	}
	public void setAutocomplete(String autocomplete){
		getStateHelper().put(Propriedades.autocomplete, autocomplete);
	}
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context);
		out.write("<form id='"+clientId+"' name='"+clientId+"' method='post' enctype='application/x-www-form-urlencoded' accept-charset='utf-8' autocomplete='"+getAutocomplete()+"'>");	
		out.write("<input type='hidden' id='"+clientId+"' name='"+clientId+"' value='"+clientId+"'>");		
	}
}
