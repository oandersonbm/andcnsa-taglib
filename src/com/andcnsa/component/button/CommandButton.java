package com.andcnsa.component.button;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlCommandButton;

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
		setStyleClass("btn btn-"+getCor());
	}
	public String getCor(){
		return (String)getStateHelper().eval(Propriedades.cor, "default");
	}
	
	public CommandButton(){
		super();
	}
}
