package br.com.cadernetadigital.component.chart;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.chart.model.BarChartModel;
import br.com.cadernetadigital.component.chart.model.ChartSeries;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="js/Chart.js")
})
public class BarChart  extends UIComponentBase{
	
	private enum Propriedades{
		model
	}
	public BarChartModel getModel(){
		return (BarChartModel)getStateHelper().eval(Propriedades.model, null);
	}
	public void setModel(BarChartModel arg0){
		getStateHelper().put(Propriedades.model, arg0);
	}

	@Override
	public String getFamily() {
		return "chart";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<div>");
		out.write("<canvas id='"+getClientId()+"' height='450' width='600' />");
		out.write("</div>");
		out.write("<script>");
		
		HashSet<String> labels = new HashSet<String>();
		if(getModel() != null){
			StringBuilder chart_dados = new StringBuilder(" datasets : [ ");
			int i_dados = 0;
			int i_dados_data = 0;
			for(ChartSeries chartSerie : getModel().getSeries()){//Loop das séries
				i_dados_data = 0;
				if(i_dados != 0)
					chart_dados.append(" , ");
				
				chart_dados.append(" { ");//Início do dataset
				chart_dados.append(" data: [");//Início do data
				for(Map.Entry<String, Float> dados : chartSerie.getValores().entrySet()){//Loop da série para pegar os dados
					if(i_dados_data != 0)
						chart_dados.append(",");
					chart_dados.append(dados.getValue());
					
					labels.add(dados.getKey());
					
					i_dados_data++;
				}
				chart_dados.append(" ] ");//Fim do data
				chart_dados.append(" } ");//Fim do dataset
				i_dados++;			
			}
			chart_dados.append(" ] ");//Fim do bloco de datasets
			int i_label = 0;
			StringBuilder chart_label = new StringBuilder("labels: [");
			for(String label : labels){
				if(i_label != 0)
					chart_label.append(",");
				chart_label.append("'"+label+"'");
				i_label++;
			}
			chart_label.append("]");
			
			out.write(" var chartData = {"+chart_label+","+chart_dados+"}; ");
			out.write(" window.onload = function(){ "
					+ " var ctx = document.getElementById('"+getClientId()+"').getContext('2d'); "
					+ " window.myBar = new Chart(ctx).Bar(chartData, {responsive : true}); "
					+ " }; ");
			
			
		}
		out.write("</script>");
	}
	

}
