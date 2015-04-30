package br.com.cadernetadigital.component.item;

import java.io.IOException;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.lista.Lista;
import br.com.cadernetadigital.component.tabela.Tabela;
import br.com.cadernetadigital.component.tarefa.Tarefa;

public class Item extends UIComponentBase{
	private enum Propriedades {
		titulo
	}

	private ResponseWriter out;
	private FacesContext context;
	
	
	public void setTitulo(String titulo){
		getStateHelper().put(Propriedades.titulo, titulo);
	}
	public String getTitulo(){
		return (String)getStateHelper().eval(Propriedades.titulo, "");
	}
	
	
	@Override
	public String getFamily() {
		return null;
	}
	
	@Override
	public void encodeAll(FacesContext context) throws IOException {
		this.context = context;
		out = context.getResponseWriter();
		imprimeLista();
		imprimeColuna();
		imprimeTarefa();
	}
	
	private void imprimeLista() throws IOException{
		if(super.getParent().getClass() == Lista.class){
			out.write("<li>");
			this.encodeChildren(context);
			out.write("</li>");
		}		
	}
	
	private void imprimeColuna() throws IOException{
		if(super.getParent().getClass() == Tabela.class){
			out.write("<td>");
			this.encodeChildren(context);
			out.write("</td>");
		}		
	}
	
	private void imprimeTarefa() throws IOException{
		if(super.getParent().getClass() == Tarefa.class){
			
			out.write("<td id='"+getId()+"'><label>"+getTitulo());
			out.write("<input id='"+getClientId(context)+"' type='checkbox' />");
			this.encodeChildren(context);
			out.write("</td></label>");
		}		
	}
	
}
