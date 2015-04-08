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
public class ButtonContainer extends UIComponentBase{
	
	private enum Propriedades{
		col
	}
	
	public void setCol(Integer arg1){
		getStateHelper().put(Propriedades.col, arg1);
	}
	public Integer getCol(){
		return (Integer)getStateHelper().eval(Propriedades.col, 12);
	}

	@Override
	public String getFamily() {
		return "button";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<div class='col-md-"+getCol()+"'>");
		out.write("<div class='btn-container'>");
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>");
		out.write("</div>");
	}

}
