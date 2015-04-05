package br.com.cadernetadigital.component.select;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.context.FacesContext;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-checkbox.css")
})
public class SelectMany extends HtmlSelectManyCheckbox{
	private enum Propriedades{
		obrigatorio
	}
	public void setObrigatorio(Boolean arg1){
		getStateHelper().put(Propriedades.obrigatorio, arg1);
	}
	public Boolean getObrigatorio(){
		return (Boolean)getStateHelper().eval(Propriedades.obrigatorio, false);
	}
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		super.setLayout("pageDirection");
		super.setStyleClass("andcheckbox");
		super.setRequired(getObrigatorio());
		super.setRequiredMessage("Campo obrigatório");
		super.encodeBegin(context);
	}
}
