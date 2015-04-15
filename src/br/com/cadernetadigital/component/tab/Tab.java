package br.com.cadernetadigital.component.tab;

import javax.faces.component.UIComponentBase;

public class Tab extends UIComponentBase{
	private enum Propriedades{
		label
	}
	public void setLabel(String arg1){
		getStateHelper().put(Propriedades.label, arg1);
	}
	public String getLabel(){
		return (String)getStateHelper().eval(Propriedades.label, null);
	}
	@Override
	public String getFamily() {
		return "layout";
	}

}
