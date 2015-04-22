package br.com.cadernetadigital.component.modal;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.panel.Panel;

public class Modal extends Panel{
	@Override
	public void encodeAll(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<div id='"+getId()+"' class='modal fade'>");
		out.write("<div class='modal-dialog'>");

		out.write("<div class='modal-content'>");
		
		out.write("<div class='modal-header'>");
		out.write("<button type='button' modal='"+getId()+"' class='close'><span>&times;</span></button>");
		out.write("<h4 class='modal-title'>"+getTitulo()+"</h4>");
		out.write("</div>");//</modal-header>
		
		out.write("<div class='modal-body'>");
		super.encodeChildren(context);
		out.write("</div>");//</modal-body>
		
		out.write("</div>");//</modal-content>
		
		out.write("</div>");//</modal-dialog>
		out.write("</div>");//</modal>
	}
}
