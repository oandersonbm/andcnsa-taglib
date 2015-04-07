import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cadernetadigital.component.chart.model.BarChartModel;
import br.com.cadernetadigital.component.chart.model.ChartSeries;


@ManagedBean
@RequestScoped
public class TesteBean {
	private BarChartModel model;
	private ChartSeries serie;
	@PostConstruct
	public void init(){
		model = new BarChartModel();
		serie = new ChartSeries();
		serie.add("Janeiro", 11f);
		serie.add("Fevereiro", 10f);
		serie.add("Março", 11f);
		serie.add("Abril", 10f);
		serie.add("Maio", 11f);
		serie.add("Junho", 10f);
		serie.add("Julho", 10f);
		serie.add("Agosto", 10f);
		serie.add("Setembro", 10f);
		serie.add("Outubro", 10f);
		serie.add("Novembro", 10f);
		serie.add("Dezembro", 10f);
		getModel().addSeries(serie);
		serie = new ChartSeries();
		serie.add("Janeiro", 15f);
		serie.add("Fevereiro", 20f);
		getModel().addSeries(serie);
	}
	public BarChartModel getModel() {
		return model;
	}
	public void setModel(BarChartModel model) {
		this.model = model;
	}
}
