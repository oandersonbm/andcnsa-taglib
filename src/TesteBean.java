import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cadernetadigital.component.chart.model.BarChartModel;
import br.com.cadernetadigital.component.chart.model.ChartColor;
import br.com.cadernetadigital.component.chart.model.ChartSeries;


@ManagedBean
@RequestScoped
public class TesteBean {
	private BarChartModel model;
	private BarChartModel model2;
	private ChartSeries serie;
	@PostConstruct
	public void init(){
		model = new BarChartModel("Janeiro","Fevereiro", "Março", "Abril");
		serie = new ChartSeries("Zé do Alho");
		serie.setCor(ChartColor.CINZA);
		serie.add("Janeiro", 11);
		serie.add("Fevereiro", 10);
		serie.add("Março", 11);
		serie.add("Abril", 10);
		getModel().addSeries(serie);
		serie = new ChartSeries("Zé da Cebola");
		serie.add("Janeiro", 15);
		serie.add("Fevereiro", 20);
		serie.add("Abril", 20);
		getModel().addSeries(serie);
		
		
		model2 = new BarChartModel("Janeiro","Fevereiro", "Março", "Abril");
		serie = new ChartSeries("Zé do Alho");
		serie.setCor(ChartColor.CINZA);
		serie.add("Janeiro", 12);
		serie.add("Fevereiro", 12);
		serie.add("Março", 12);
		serie.add("Abril", 12);
		getModel2().addSeries(serie);
		serie = new ChartSeries("Zé da Cebola");
		serie.add("Janeiro", 12);
		serie.add("Fevereiro", 22);
		serie.add("Abril", 22);
		getModel2().addSeries(serie);
	}
	public BarChartModel getModel() {
		return model;
	}
	public void setModel(BarChartModel model) {
		this.model = model;
	}
	public BarChartModel getModel2() {
		return model2;
	}
	public void setModel2(BarChartModel model2) {
		this.model2 = model2;
	}
}
