package br.com.cadernetadigital.component.chart.model;

public enum ChartColor {
	CINZA{
		@Override
		public String toString() {
			return " fillColor: 'rgba(125,125,125,.5)', highlightFill: 'rgba(125,125,125,.9)', strokeColor: 'rgba(125,125,125,1)', pointColor: 'rgba(125,125,125,1)' ";
		}		
	},
	INDIGO{
		@Override
		public String toString() {
			return " fillColor: 'rgba(63,81,181,.5)', highlightFill: 'rgba(63,81,181,.9)', strokeColor: '#3F51B5', pointColor: '#3F51B5' ";
		}		
	};
}
