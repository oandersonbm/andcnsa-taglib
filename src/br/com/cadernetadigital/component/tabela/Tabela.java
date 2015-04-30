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
	@ResourceDependency(library="andcnsa", name="js/jquery.dataTables.min.js"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-dataTable.css")
})
public class Tabela extends Lista{
	private enum Propriedades{
		paginacao, busca, linhas
	}
	public Boolean getPaginacao(){
		return (Boolean)getStateHelper().eval(Propriedades.paginacao, false);
	}
	public void setPaginacao(Boolean arg1){
		getStateHelper().put(Propriedades.paginacao, arg1);
	}
	public Boolean getBusca(){
		return (Boolean)getStateHelper().eval(Propriedades.busca, false);
	}
	public void setBusca(Boolean arg1){
		getStateHelper().put(Propriedades.busca, arg1);
	}
	public Integer getLinhas(){
		return (Integer)getStateHelper().eval(Propriedades.linhas, 10);
	}
	public void setLinhas(Integer arg1){
		getStateHelper().put(Propriedades.linhas, arg1);
	}
	private List<String> titulos = new ArrayList<String>();
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		out.write("<div id='"+getClientId(context)+"'>");
		out.write("<table id='"+getId()+"' class='table table-striped table-bordered' cellspacing='0' width='100%'>");
		encodaTitulos(context);
		super.encodeBegin(context);
	}
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		super.encodeEnd(context);
		out.write("</table>");
		
		Boolean info = true;
		if(!getPaginacao())
			info = false;
		out.write("<script>$(document).ready(function(){");
		out.write("$('#"+getId()+"').DataTable({"
				+ "'language': {"
				+ "'lengthMenu': '_MENU_', "
				+ "'zeroRecords': 'Não possui registros',"
				+ "'info': 'Paginação _PAGE_ de _PAGES_',"
				+ "'infoEmpty': 'Nenhum registro encontrado', "
				+ "'infoFiltered': '(filtrado de um total de _MAX_ registros)',"
				+ "'sSearch':'',"
				+ "'sSearchPlaceholder':'Procura...',"
				+ "oPaginate:{sFirst:'Primeira',sLast:'Última',sNext:'Próxima',sPrevious:'Anterior'}"
				+ "}"
				+ " , info:"+info
				+ " , paging:"+getPaginacao()
				+ " , 'searching':"+getBusca()
				+ " , 'pageLength':"+getLinhas()
				+ " , 'lengthMenu': [ ["+getLinhas()+", "+(getLinhas()*2)+", "+(getLinhas()*4)+", -1], ["+getLinhas()+", "+(getLinhas()*2)+", "+(getLinhas()*4)+", 'Todos'] ]"
				+ "}); $('#"+getId()+"').wrap('<div class=\"table-responsive\"></div>');");
		out.write("});");
		out.write("</script>");
		out.write("</div>");
	}
	@Override
	protected void beforeProcess(FacesContext faces)
			throws IOException {
		ResponseWriter out = faces.getResponseWriter();
		out.write("<tr>");
	}
	@Override
	protected void afterProcess(FacesContext faces)
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
