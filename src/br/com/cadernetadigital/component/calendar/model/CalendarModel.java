package br.com.cadernetadigital.component.calendar.model;

import java.util.Date;

public class CalendarModel {
	private String titulo;
	private Date inicio;
	private Date fim;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
}
