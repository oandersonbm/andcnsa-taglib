package br.com.cadernetadigital.component.chart.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarChartModel {
	private List<String> labels;
	private List<ChartSeries> series;
	
	public BarChartModel(String...label){
		setLabels(new ArrayList<String>(Arrays.asList(label)));
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

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
}
