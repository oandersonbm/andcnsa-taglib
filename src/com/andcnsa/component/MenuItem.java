package com.andcnsa.component;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.andcnsa.component.util.Link;

@FacesComponent(value="menuItem", createTag=true, namespace="http://andcnsa.com/jsf/component")
@ResourceDependencies({
	@ResourceDependency(library="layout", name="css/bootstrap.min.css"),
	@ResourceDependency(library="layout", name="css/andcnsa-menubar.css")
})
public class MenuItem extends UIComponentBase{
	private enum Propriedades{
		titulo, href
	}
	public void setTitulo(String titulo){
		getStateHelper().put(Propriedades.titulo, titulo);
	}
	public String getTitulo(){
		return (String)getStateHelper().eval(Propriedades.titulo, "");
	}
	public void setHref(String href){
		getStateHelper().put(Propriedades.href, href);
	}
	public String getHref(){
		return (String)getStateHelper().eval(Propriedades.href, "#");
	}
	@Override
	public String getFamily() {
		return "layout";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<li>");
		String link = (String)Link.getOutcomeLink(context, getHref());
		out.write("<a href='"+link+"'>");
		out.write(getTitulo());
		
		
		
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</a>");
		out.write("</li>");
		
	}
}
