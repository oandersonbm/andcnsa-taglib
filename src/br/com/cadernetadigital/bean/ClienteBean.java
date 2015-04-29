package br.com.cadernetadigital.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.cadernetadigital.model.cliente.Cliente;

@ManagedBean
public class ClienteBean {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public List<Cliente> getClientes() {
		Cliente a = new Cliente("51561651560","Anderson","Barbosa","andcnsamobile@gmail.com");
		clientes.add(a);
		a = new Cliente("12345678910","Josicleidson","Barbos","andcnsamobil@gmail.com");
		clientes.add(a);
		a = new Cliente("12345678911","Jsiclidson","Basa","annamob@mail.com");
		clientes.add(a);
		a = new Cliente("12345678910","Josileidson","Barbos","anamobile@gmai.com");
		clientes.add(a);
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
