package com.andcnsa.component;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value="subMenu", createTag=true, namespace="http://andcnsa.com/jsf/component")
@ResourceDependencies({
	@ResourceDependency(library="layout", name="css/bootstrap.min.css"),
	@ResourceDependency(library="layout", name="css/andcnsa-menubar.css")
})
public class SubMenu extends UIComponentBase{
	private enum Propriedades{
		titulo
	}
	public void setTitulo(String titulo){
		getStateHelper().put(Propriedades.titulo, titulo);
	}
	public String getTitulo(){
		return (String)getStateHelper().eval(Propriedades.titulo, null);
	}
	@Override
	public String getFamily() {
		return "layout";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<li class='item'>");
		out.write("<a href='#'>");
		out.write(getTitulo());
		out.write("</a>");
		out.write("<ul class='submenu'>");
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</ul>");
		out.write("</li>");
	}
}
