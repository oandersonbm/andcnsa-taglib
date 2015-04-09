package br.com.cadernetadigital.component.chart.model;

import java.util.HashMap;

public class ChartSeries {
	private String label;
	private ChartColor cor = null;
	private HashMap<String,Number> valores;
	public ChartSeries(String label){
		this.label = label;
		setValores(new HashMap<String,Number>());
	}
	public ChartSeries(ChartColor cor){
		this.cor = cor;
		setValores(new HashMap<String,Number>());
	}

	public void add(String label, Number valor){
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
	
	public Number getValor(String label){
		if(valores.get(label) != null)
			return valores.get(label);
		else
			return 0;
	}

	public HashMap<String, Number> getValores() {
		return valores;
	}

	public void setValores(HashMap<String,Number> valores) {
		this.valores = valores;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
