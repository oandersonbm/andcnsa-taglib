package br.com.cadernetadigital.component.select;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css")
})
public class SelectOneMenu extends HtmlSelectOneMenu{
	private enum Propriedades{
		obrigatorio, label, col, ajax
	}
	public void setObrigatorio(Boolean arg1){
		getStateHelper().put(Propriedades.obrigatorio, arg1);
	}
	public Boolean getObrigatorio(){
		return (Boolean)getStateHelper().eval(Propriedades.obrigatorio, false);
	}
	public void setAjax(Boolean arg1){
		getStateHelper().put(Propriedades.ajax, arg1);
	}
	public Boolean getAjax(){
		return (Boolean)getStateHelper().eval(Propriedades.ajax, false);
	}
	public void setLabel(String arg1){
		getStateHelper().put(Propriedades.label, arg1);
	}
	public String getLabel(){
		return (String)getStateHelper().eval(Propriedades.label, "");
	}

	public void setCol(Integer col) {
		getStateHelper().put(Propriedades.col, col);
	}

	public Integer getCol() {
		return (Integer) getStateHelper().eval(Propriedades.col, 12);
	}
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		super.setRequired(getObrigatorio());
		super.setRequiredMessage("Campo obrigatório");
		super.setStyleClass("andselectonemenu form-control");
		if(!getAjax()){
			out.write("<div class='col-md-"+getCol()+"'>");
			out.write("<div class='form-group'>");
			out.write("<label for='"+getClientId()+"'>"+getLabel()+"</label>");
		}
		super.encodeBegin(context);
	}
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		List<FacesMessage> mensagens = context.getMessageList(getClientId(context));
		ResponseWriter out = context.getResponseWriter();
		super.encodeEnd(context);
		for(FacesMessage mensagem : mensagens){
			if(mensagem.getSeverity() == FacesMessage.SEVERITY_ERROR)
				out.write("<div class='form-return erro fa fa-times-circle'>"+mensagem.getDetail()+"</div>");
			else if(mensagem.getSeverity() == FacesMessage.SEVERITY_WARN)
				out.write("<div class='form-return warning fa fa-exclamation-circle'>"+mensagem.getDetail()+"</div>");
			else
				out.write("<div class='form-return info fa fa-info-circle'>"+mensagem.getDetail()+"</div>");
		}
		if(!getAjax()){
			out.write("</div>");//</form-group>
			out.write("</div>");//</col>
		}
	}
}
