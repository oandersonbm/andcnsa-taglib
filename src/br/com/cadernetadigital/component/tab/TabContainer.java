package br.com.cadernetadigital.component.tab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.util.ClientId;

@ResourceDependencies({
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap.min.css"),
		@ResourceDependency(library = "andcnsa", name = "css/font-awesome.min.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa-fonts.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa-tab.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa.css"),
		@ResourceDependency(library = "andcnsa", name = "js/jquery.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/bootstrap.min.js"),
		@ResourceDependency(library = "andcnsa", name = "js/cdigital.js") })
public class TabContainer extends UIComponentBase {

	private enum Propriedades {
		col
	}

	public void setCol(Integer arg1) {
		getStateHelper().put(Propriedades.col, arg1);
	}

	public Integer getCol() {
		return (Integer) getStateHelper().eval(Propriedades.col, 12);
	}

	@Override
	public String getFamily() {
		return "layout";
	}

	@Override
	public void encodeAll(FacesContext arg0) throws IOException {
		List<Tab> tabs = new ArrayList<Tab>();
		ResponseWriter out = arg0.getResponseWriter();
		out.write("<div class='col-md-" + getCol() + "'>");
		out.write("<div class='tab-container'>");
		out.write("<ul class='nav nav-tabs'>");
		Tab tab;
		String active = "active";
		
		for (UIComponent component : getChildren()) {
			if (component instanceof Tab) {
				tab = (Tab) component;
				if(tab.isRendered()){
					tabs.add(tab);
					out.write("<li class='" + active + "'>");
					out.write("<a href='#" + ClientId.getLastId(tab.getClientId()) + "'>");
					out.write(tab.getLabel());
					out.write("</a>");
					out.write("</li>");
					active = "";
				}
			}
		}
		out.write("</ul>");

		out.write("<div class='tab-content row'>");
		
		
		active = "active";
		for (Tab t : tabs) {
			out.write("<div class='tab-pane " + active + "' id='"
					+ ClientId.getLastId(t.getClientId()) + "'>");
			t.encodeAll(arg0);
			out.write("</div>");
			active = "";
		}
		out.write("</div>");// </tab-content>
		out.write("</div>");// </tab-container>
		out.write("</div>");// </col>

	}

}
