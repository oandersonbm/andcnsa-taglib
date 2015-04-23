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
	@ResourceDependency(library="andcnsa", name="css/andcnsa-button.css"),
	@ResourceDependency(library="andcnsa", name="js/jquery.min.js"),
	@ResourceDependency(library="andcnsa", name="js/bootstrap.min.js")
})
public class CommandButton extends HtmlCommandButton{
	private enum Propriedades{
		cor, modal
	}
	public void setCor(String cor){
		getStateHelper().put(Propriedades.cor, cor);
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "default");
	}
	public void setModal(String modal){
		getStateHelper().put(Propriedades.modal, modal);
	}
	public String getModal(){
		return (String)getStateHelper().eval(Propriedades.modal, null);
	}
	
	public CommandButton(){
		super();
	}
	
	@Override
	public void encodeAll(FacesContext context) throws IOException{
		
		setStyleClass("btn btn-"+getCor());
		if(getModal() != null){
			setType("button");
			setOnclick("$('#"+getModal()+"').modal('toggle');");
		}
		super.encodeBegin(context);
	}
}
