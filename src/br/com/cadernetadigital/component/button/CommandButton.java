package br.com.cadernetadigital.component.button;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-button.css")
})
public class CommandButton extends HtmlCommandButton{
	private enum Propriedades{
		cor
	}
	public void setCor(String cor){
		getStateHelper().put(Propriedades.cor, cor);
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "default");
	}
	
	public CommandButton(){
		super();
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		setStyleClass("btn btn-"+getCor());
		super.encodeBegin(context);
	}
}
