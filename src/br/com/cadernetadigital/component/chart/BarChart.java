package br.com.cadernetadigital.component.chart;

import java.io.IOException;
import java.util.ArrayList;
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
		
		if(getModel() != null){
			
			out.write(" var chartData"+getClientId()+" = {"+geraChartData()+"}; ");
			out.write(" var ctx"+getClientId()+" = document.getElementById('"+getClientId()+"').getContext('2d'); "
					+ " var myBar"+getClientId()+" = new Chart(ctx"+getClientId()+").Bar(chartData"+getClientId()+", {responsive : true, scaleShowLabels: true,multiTooltipTemplate: '<%= datasetLabel %> - <%= value %>'}); ");
			
			
		}
		out.write("</script>");
	}
	private String geraChartData() {
		ArrayList<String> labels = new ArrayList<String>();
		//Preenchendo as séries
		StringBuilder dataset = new StringBuilder(" datasets:[");
		int j = 0;
		int i = 0;
		for(ChartSeries s : getModel().getSeries()){
			if(j != 0)
				dataset.append(",");
			dataset.append("{");
			dataset.append(s.getCor());
			dataset.append(", label: '"+s.getLabel()+"', data:[");
			i = 0;
			for(String l : getModel().getLabels()){
				if(!labels.contains(l))
					labels.add(l);
				if(i != 0)
					dataset.append(",");
				dataset.append(s.getValor(l));
				i++;
			}
			dataset.append("]");
			dataset.append("}");
			j++;
		}
		dataset.append("]");
		
		//Organizando os labels
		i = 0;
		StringBuilder label = new StringBuilder(" labels: [");
		for(String l2 : labels){
			if(i != 0)
				label.append(",");
			label.append("'"+l2+"'");
			i++;
		}
		label.append("]");
		
		i=0;
		
		return label.toString()+","+dataset.toString();
	}
	

}
