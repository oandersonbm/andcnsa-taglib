package com.andcnsa.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value = "inputText", createTag = true, namespace = "http://andcnsa.com/jsf/component")
@ResourceDependencies({
		@ResourceDependency(library = "layout", name = "css/bootstrap.min.css"),
		@ResourceDependency(library = "layout", name = "css/andcnsa-input.css") 
})
public class InputText extends UIInput {
	private enum Propriedades {
		tipo, fecha
	}

	public void setTipo(String tipo) {
		getStateHelper().put(Propriedades.tipo, tipo);
	}

	public String getTipo() {
		return (String) getStateHelper().eval(Propriedades.tipo, "");
	}

	@Override
	public String getFamily() {
		return "form";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		String clientId = getClientId(context);
		
		
		out.write("<div class='form-group has-"+getTipo()+"'>");
		out.startElement("input", this);
		out.writeAttribute("name", clientId + ".andcnsa", "clientId");
		out.writeAttribute("class", "form-control ", null);
		Object v = getValue();
		if (v != null)
			out.writeAttribute("value", v.toString(), "value");
		out.endElement("input");
		
		
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		out.write("</div>"); //</form-group>
	}

	@Override
	public void decode(FacesContext context) {
		@SuppressWarnings("rawtypes")
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		String clientId = getClientId(context);
		try {

			String valorEnviado = (String) requestMap
					.get(clientId + ".andcnsa");
			setSubmittedValue(valorEnviado);
			setValid(true);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			setSubmittedValue((String) requestMap.get(clientId));
		}

	}
}
