package com.andcnsa.component.panel;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-panel.css")
})
public class Panel extends UIComponentBase{
	private enum Propriedades{
		titulo, subtitulo, col, cor, fecha
	}
	public void setTitulo(String titulo){
		getStateHelper().put(Propriedades.titulo, titulo);
	}
	public String getTitulo(){
		return (String)getStateHelper().eval(Propriedades.titulo, null);
	}
	public void setCol(Integer col){
		getStateHelper().put(Propriedades.col, col);
	}
	public Integer getCol(){
		return (Integer)getStateHelper().eval(Propriedades.col, 12);
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
		out.write("<div class='andcnsa-panel col-md-"+getCol()+"'>");
		out.write("<div class='panel panel-"+getCor()+"'>");
		out.write("<div class='panel-heading'>");
		out.write(getTitulo());
		out.write("</div>");
		out.write("<div class='panel-body'>");
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>");// </panel-body>
		out.write("</div>");// </panel>
		out.write("</div>");// </col>
	}
}
