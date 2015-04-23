package br.com.cadernetadigital.component.datatable;

import java.io.IOException;

import javax.faces.component.UIColumn;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class Column extends UIColumn{
	
	@Override
	public void encodeAll(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("Teste");
	}
}
