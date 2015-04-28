package br.com.cadernetadigital.component.tabela;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.item.Item;
import br.com.cadernetadigital.component.lista.Lista;
@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="js/jquery.min.js"),
	@ResourceDependency(library="andcnsa", name="js/jquery.dataTables.min.js")
})
public class Tabela extends Lista{
	private List<String> titulos = new ArrayList<String>();
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		out.write("<div id='"+getClientId(context)+"'>");
		out.write("<table id='"+getId()+"' class='table'>");
		encodaTitulos(context);
		super.encodeBegin(context);
	}
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		super.encodeEnd(context);
		out.write("</table>");
		out.write("<script>$(document).ready(function(){");
		out.write("alert('OK');");
		out.write("});");
		out.write("</script>");
		out.write("</div>");
	}
	@Override
	protected void preProcess(FacesContext faces)
			throws IOException {
		ResponseWriter out = faces.getResponseWriter();
		out.write("<tr>");
	}
	@Override
	protected void postProcess(FacesContext faces)
			throws IOException {
		ResponseWriter out = faces.getResponseWriter();
		out.write("</tr>");
	}
	private void encodaTitulos(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		
		out.write("<thead>");
		for(UIComponent componente : this.getChildren()){
			if(componente.getClass() == Item.class){
				out.write("<th>");
				out.write(((Item)componente).getTitulo());
				out.write("</th>");
			}
		}
		out.write("</thead>");
	}
	public void adicionaTitulo(String titulo){
		titulos.add(titulo);
	}
}
