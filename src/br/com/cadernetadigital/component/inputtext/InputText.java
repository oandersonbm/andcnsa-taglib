package br.com.cadernetadigital.component.inputtext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.inputtext.validador.documento.CpfValidator;
import br.com.cadernetadigital.component.inputtext.validador.email.EmailValidator;
import br.com.cadernetadigital.component.inputtext.validador.obrigatorio.ObrigatorioValidator;

@ResourceDependencies({
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap.min.css"),
		@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap-datepicker.min.css"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.pt-BR.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/cdigital.js")
})
public class InputText extends UIInput {
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
	public String getFamily() {
		return "form";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		new EmailValidator().verifica(this);
		new CpfValidator().verifica(this);
		new ObrigatorioValidator().verifica(this);
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context) + ".andcnsa";
		List<FacesMessage> mensagens = context.getMessageList(getClientId(context));
		
		out.write("<div class='col-md-" + getCol() + "'>");
		out.write("<div class='form-group'>");
		if (getLabel() != null) {
			out.write("<label for='" + clientId + "'>" + getLabel() + "</label>");
		}
		
		
		if(!getTipo().equals("static")){
			out.startElement("input", this);
			if (getPlaceholder() != null) {
				out.writeAttribute("placeholder", getPlaceholder(), null);
			}
			out.writeAttribute("name", clientId, "clientId");
			
			if(getTipo().equals("data")){
				out.writeAttribute("class", "form-control "+getTipo(), null);
				out.writeAttribute("type", "text", null);				
			}else{
				out.writeAttribute("class", "form-control ", null);
				out.writeAttribute("type", getTipo(), null);
			}
			Object v = getValue();
			if (v != null)
				out.writeAttribute("value", v.toString(), "value");
			out.endElement("input");
		}else{
			out.write("<p class='form-control-static'>"+getValue()+"</p>");
		}
		
		for(FacesMessage mensagem : mensagens){
			if(mensagem.getSeverity() == FacesMessage.SEVERITY_ERROR)
				out.write("<div class='form-return erro fa fa-times-circle'>"+mensagem.getDetail()+"</div>");
			else if(mensagem.getSeverity() == FacesMessage.SEVERITY_WARN)
				out.write("<div class='form-return warning fa fa-exclamation-circle'>"+mensagem.getDetail()+"</div>");
			else
				out.write("<div class='form-return info fa fa-info-circle'>"+mensagem.getDetail()+"</div>");
		}

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>"); // </form-group>
		out.write("</div>"); // </col>
	}

	@Override
	public void decode(FacesContext context) {
		@SuppressWarnings("rawtypes")
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		String clientId = getClientId(context) + ".andcnsa";
		try {

			String valorEnviado = (String) requestMap
					.get(clientId);
			setSubmittedValue(valorEnviado);
			setValid(true);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			setSubmittedValue((String) requestMap.get(clientId));
		}

	}
}
