package br.com.cadernetadigital.component.menu;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.util.Link;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-menubar.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css")
})
public class MenuItem extends UIComponentBase{
	private enum Propriedades{
		titulo, href, cicon, ficon
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
	public void setCicon(String arg){
		getStateHelper().put(Propriedades.cicon, "icd icd-"+arg);
	}
	public String getCicon(){
		return (String)getStateHelper().eval(Propriedades.cicon, "");
	}
	public void setFicon(String arg){
		getStateHelper().put(Propriedades.ficon, "fa fa-"+arg);
	}
	public String getFicon(){
		return (String)getStateHelper().eval(Propriedades.ficon, "");
	}
	
	@Override
	public String getFamily() {
		return "layout";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<li class='item'>");
		String link = (String)Link.getOutcomeLink(context, getHref());
		out.write("<a href='"+link+"' class='"+getFicon()+" "+getCicon()+"'>");
		out.write(getTitulo());
		
		
		
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</a>");
		out.write("</li>");
		
	}
}
