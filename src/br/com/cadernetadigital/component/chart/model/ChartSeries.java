package br.com.cadernetadigital.component.chart.model;

import java.util.HashMap;

public class ChartSeries {
	private HashMap<String, Float> valores;
	
	public ChartSeries(){
		valores = new HashMap<String, Float>();
	}

	public HashMap<String, Float> getValores() {
		return valores;
	}
	public void add(String label, Float valor){
		valores.put(label, valor);
	}
	
}
