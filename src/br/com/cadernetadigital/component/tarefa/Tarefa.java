package br.com.cadernetadigital.component.tarefa;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.lista.Lista;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/andcnsa-tarefa.css")
})
public class Tarefa extends Lista{
	private ResponseWriter out;
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		out = context.getResponseWriter();
		out.write("<table class='tarefa' id='"+getClientId(context)+"'>");
		super.encodeBegin(context);
	}
	@Override
	protected void beforeProcess(FacesContext context) throws IOException {
		out = context.getResponseWriter();
		out.write("<tr id='"+getClientId(context)+"'>");
		super.beforeProcess(context);
	}
	@Override
	protected void afterProcess(FacesContext context) throws IOException {
		out = context.getResponseWriter();
		out.write("</tr>");
		super.afterProcess(context);
	}
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		out = context.getResponseWriter();
		super.encodeEnd(context);
		out.write("</table>");
	}
}
