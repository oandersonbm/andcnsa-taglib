package br.com.cadernetadigital.component.button;

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
	@ResourceDependency(library="andcnsa", name="css/andcnsa-button.css")
})
public class Button extends UIComponentBase{
	private enum Propriedades{
		cor, tipo
	}
	public void setCor(String cor){
		getStateHelper().put(Propriedades.cor, cor);
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "default");
	}
	public void setTipo(String tipo){
		getStateHelper().put(Propriedades.tipo, tipo);
	}
	public String getTipo(){
		return (String)getStateHelper().eval(Propriedades.tipo, "submit");
	}
	
	@Override
	public String getFamily() {
		return "layout";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context) + ".andcnsa";
		 
		
		out.startElement("button", this);
		out.writeAttribute("name", clientId, "clientId");
		out.writeAttribute("class", "btn btn-"+getCor(), null);
		out.writeAttribute("type", getTipo(), null);
	
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.endElement("button");
	}
}
