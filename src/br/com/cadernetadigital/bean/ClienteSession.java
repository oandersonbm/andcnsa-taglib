package br.com.cadernetadigital.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.cadernetadigital.model.cliente.Cliente;

@ManagedBean
@SessionScoped
public class ClienteSession {
	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
