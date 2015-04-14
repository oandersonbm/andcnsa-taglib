package br.com.cadernetadigital.component.inputtext;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.inputtext.validador.documento.CpfValidator;
import br.com.cadernetadigital.component.inputtext.validador.email.EmailValidator;
import br.com.cadernetadigital.component.inputtext.validador.obrigatorio.ObrigatorioValidator;

@ResourceDependencies({
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap.min.css"),
		@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa-input.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap-datepicker.min.css"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.pt-BR.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/cdigital.js")
})
public class InputText extends HtmlInputText {
	private enum Propriedades {
		label, tipo, obrigatorio, placeholder, col
	}

	public void setLabel(String label) {
		getStateHelper().put(Propriedades.label, label);
	}

	public String getLabel() {
		return (String) getStateHelper().eval(Propriedades.label, null);
	}

	public void setTipo(String tipo) {
		getStateHelper().put(Propriedades.tipo, tipo);
	}

	public String getTipo() {
		return (String) getStateHelper().eval(Propriedades.tipo, "");
	}

	public void setObrigatorio(Boolean obrigatorio) {
		getStateHelper().put(Propriedades.obrigatorio, obrigatorio);
	}

	public Boolean getObrigatorio() {
		return (Boolean) getStateHelper().eval(Propriedades.obrigatorio, false);
	}

	public void setPlaceholder(String placeholder) {
		getStateHelper().put(Propriedades.placeholder, placeholder);
	}

	public String getPlaceholder() {
		return (String) getStateHelper().eval(Propriedades.placeholder, null);
	}

	public void setCol(Integer col) {
		getStateHelper().put(Propriedades.col, col);
	}

	public Integer getCol() {
		return (Integer) getStateHelper().eval(Propriedades.col, 12);
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		new EmailValidator().verifica(this);
		new CpfValidator().verifica(this);
		new ObrigatorioValidator().verifica(this);
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context) + ".andcnsa";
		
		out.write("<div class='col-md-" + getCol() + "'>");
		out.write("<div class='form-group'>");
		if (getLabel() != null) {
			out.write("<label for='" + clientId + "'>" + getLabel() + "</label>");
		}
		
		
		if(!getTipo().equals("static")){
			setStyleClass("form-control "+getTipo());
			super.encodeBegin(context);
		}else{
			out.write("<p class='form-control-static'>"+getValue()+"</p>");
		}

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		if (getLabel() != null) {
			if(!getTipo().equals("static"))
				super.encodeEnd(context);
			
			List<FacesMessage> mensagens = context.getMessageList(getClientId(context));
			
			for(FacesMessage mensagem : mensagens){
				if(mensagem.getSeverity() == FacesMessage.SEVERITY_ERROR)
					out.write("<div class='form-return erro fa fa-times-circle'>"+mensagem.getDetail()+"</div>");
				else if(mensagem.getSeverity() == FacesMessage.SEVERITY_WARN)
					out.write("<div class='form-return warning fa fa-exclamation-circle'>"+mensagem.getDetail()+"</div>");
				else
					out.write("<div class='form-return info fa fa-info-circle'>"+mensagem.getDetail()+"</div>");
			}
		}
		out.write("</div>"); // </form-group>
		out.write("</div>"); // </col>
	}
	
	@Override
	public void decode(FacesContext context){
		if (getLabel() != null) {
			super.decode(context);
		}
	}
}
