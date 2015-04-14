package br.com.cadernetadigital.component.widget;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlOutcomeTargetLink;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-widget.css")
})
public class WidgetLink extends HtmlOutcomeTargetLink{
	private enum Propriedades{
		col, icon, cor, ficon
	}
	public void setCol(Integer arg1){
		getStateHelper().put(Propriedades.col, arg1);
	}
	public Integer getCol(){
		return (Integer)getStateHelper().eval(Propriedades.col, 12);
	}
	public void setIcon(String arg1){
		getStateHelper().put(Propriedades.icon, "icd icd-"+arg1);
	}
	public String getIcon(){
		return (String)getStateHelper().eval(Propriedades.icon, "");
	}
	public void setFicon(String arg1){
		getStateHelper().put(Propriedades.ficon, "fa fa-"+arg1);
	}
	public String getFicon(){
		return (String)getStateHelper().eval(Propriedades.ficon, "");
	}
	public void setCor(String arg1){
		getStateHelper().put(Propriedades.cor, "widget-"+arg1);
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "widget-cinza");
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		setStyleClass("widgetLink "+getIcon()+" "+getFicon()+" "+getCor());
		ResponseWriter out = context.getResponseWriter();
		out.write("<div class='col-md-"+getCol()+"'>");
		super.encodeBegin(context);
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		super.encodeEnd(context);
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>");
	}
}
