package br.com.cadernetadigital.component.chart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChartSeries {
	private ChartColor cor = null;
	private List<String> labels;
	private HashMap<String,Float> valores;
	
	public ChartSeries(){
		setValores(new HashMap<String,Float>());
		setLabels(new ArrayList<String>());
	}

	public void add(String label, Float valor){
		getLabels().add(label);
		getValores().put(label,valor);
	}

	public ChartColor getCor() {
		if(cor == null)
			cor = ChartColor.CINZA;
		return cor;
	}

	public void setCor(ChartColor cor) {
		this.cor = cor;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public HashMap<String, Float> getValores() {
		return valores;
	}

	public void setValores(HashMap<String,Float> valores) {
		this.valores = valores;
	}
	
}
