import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cadernetadigital.component.chart.model.ChartModel;
import br.com.cadernetadigital.component.chart.model.ChartColor;
import br.com.cadernetadigital.component.chart.model.ChartSeries;


@ManagedBean
@RequestScoped
public class TesteBean {
	private ChartModel model;
	private ChartModel model2;
	private ChartSeries serie;
	@PostConstruct
	public void init(){
		model = new ChartModel("Janeiro","Fevereiro", "Março", "Abril");
		serie = new ChartSeries("Zé do Alho");
		serie.setCor(ChartColor.CINZA);
		serie.add("Janeiro", 11);
		serie.add("Fevereiro", 10);
		serie.add("Março", 11);
		serie.add("Abril", 10);
		getModel().addSeries(serie);
		serie = new ChartSeries("Zé da Cebola");
		serie.setCor(ChartColor.INDIGO);
		serie.add("Janeiro", 15);
		serie.add("Fevereiro", 20);
		serie.add("Abril", 20);
		getModel().addSeries(serie);
		
		
		model2 = new ChartModel("Janeiro","Fevereiro", "Março", "Abril");
		serie = new ChartSeries("Zé do Alho");
		serie.setCor(ChartColor.CINZA);
		serie.add("Janeiro", 12);
		serie.add("Fevereiro", 13);
		serie.add("Março", 12);
		serie.add("Abril", 15);
		getModel2().addSeries(serie);
		serie = new ChartSeries("Zé da Cebola");
		serie.setCor(ChartColor.INDIGO);
		serie.add("Janeiro", 12);
		serie.add("Fevereiro", 22);
		serie.add("Abril", 22);
		getModel2().addSeries(serie);
	}
	public ChartModel getModel() {
		return model;
	}
	public void setModel(ChartModel model) {
		this.model = model;
	}
	public ChartModel getModel2() {
		return model2;
	}
	public void setModel2(ChartModel model2) {
		this.model2 = model2;
	}
}
