package com.andcnsa.component;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value="button", createTag=true, namespace="http://andcnsa.com/jsf/component")
@ResourceDependencies({
	@ResourceDependency(library="layout", name="css/bootstrap.min.css"),
	@ResourceDependency(library="layout", name="css/andcnsa-button.css")
})
public class Button extends UIComponentBase{
	private enum Propriedades{
		cor
	}
	public void setCor(String cor){
		getStateHelper().put(Propriedades.cor, cor);
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "default");
	}
	
	@Override
	public String getFamily() {
		return "layout";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<button class='btn btn-"+getCor()+"'>");
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</button>");// </button>
	}
}
