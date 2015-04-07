package br.com.cadernetadigital.component.chart.model;

import java.util.ArrayList;
import java.util.List;

public class BarChartModel {
	private List<ChartSeries> series;
	
	public BarChartModel(){
		series = new ArrayList<ChartSeries>();
	}
	
	public void addSeries(ChartSeries serie){
		series.add(serie);
	}

	public List<ChartSeries> getSeries() {
		return series;
	}

	public void setSeries(List<ChartSeries> series) {
		this.series = series;
	}
}
