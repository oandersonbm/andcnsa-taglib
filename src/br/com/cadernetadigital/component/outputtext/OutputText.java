package br.com.cadernetadigital.component.outputtext;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@ResourceDependencies({
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap.min.css"),
		@ResourceDependency(library = "andcnsa", name = "css/font-awesome.min.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa-fonts.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa-input.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa.css"),
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap-datepicker.min.css"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap-datepicker.pt-BR.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.mask.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.maskMoney.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/cdigital.js") })
public class OutputText extends HtmlOutputText {
	private enum Propriedades {
		label, col, tipo
	}

	public void setLabel(String arg0) {
		getStateHelper().put(Propriedades.label, arg0);
	}

	public String getLabel() {
		return (String) getStateHelper().eval(Propriedades.label, "");
	}

	public void setCol(Integer arg0) {
		getStateHelper().put(Propriedades.col, arg0);
	}

	public Integer getCol() {
		return (Integer) getStateHelper().eval(Propriedades.col, 12);
	}

	public void setTipo(Integer arg0) {
		getStateHelper().put(Propriedades.tipo, arg0);
	}

	public Integer getTipo() {
		return (Integer) getStateHelper().eval(Propriedades.tipo, 0);
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		if (getTipo() == 0) {
			out.write("<div id='"+getClientId(context)+"' class='col-md-" + getCol() + "'>");
			out.write("<div class='form-group'>");
			if (getLabel() != null) {
				out.write("<label for='" + getClientId() + "'>" + getLabel() + "</label>");
			}
			out.write("<p class='form-control-static'>");
			setId(getId()+"static");
		}
		super.encodeAll(context);

		if (getTipo() == 0) {
			out.write("</p>");
			out.write("</div>");
			out.write("</div>");
		}
	}
}
