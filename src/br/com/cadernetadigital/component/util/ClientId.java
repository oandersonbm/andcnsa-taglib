package br.com.cadernetadigital.component.util;

public class ClientId {
	public static String getLastId(String clientId){
		String[] c = clientId.split(":");
		return c[c.length-1];
	}
}
