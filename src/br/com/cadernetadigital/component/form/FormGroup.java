package br.com.cadernetadigital.component.form;

import java.io.IOException;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class FormGroup extends UIComponentBase{

	@Override
	public String getFamily() {
		return "form";
	}
	
	private enum Propriedades{
		col, label
	}

	public void setCol(Integer arg1){
		getStateHelper().put(Propriedades.col, arg1);
	}
	public Integer getCol(){
		return (Integer)getStateHelper().eval(Propriedades.col, 12);
	}
	public void setLabel(String arg1){
		getStateHelper().put(Propriedades.label, arg1);
	}
	public String getLabel(){
		return (String)getStateHelper().eval(Propriedades.label, "");
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<div class='col-md-"+getCol()+"'>");
		out.write("<div class='form-group'>");
		out.write("<label>");
		out.write(getLabel());
		out.write("</label>");
	}
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>");//</form-group>
		out.write("</div>");//</col>
	}

}
