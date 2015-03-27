package com.andcnsa.component.inputtext.validador.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.andcnsa.component.inputtext.InputText;
import com.andcnsa.component.inputtext.validador.Validador;

public class EmailValidator implements Validador, Validator{

	@Override
	public void verifica(InputText input) {
		if(input.getTipo().equals("email")){
			input.setTipo("text");
			input.addValidator(this);
		}
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object valor)
			throws ValidatorException {
		System.out.println("Verificando...");
		System.out.println(valor);
		
		Object email = (String)valor;
		if(valor != null && email.toString().length() > 0){
			if(!(email instanceof String))
				throw new IllegalArgumentException("E-mail de tipo inválido");
			
			Pattern emailPattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
			Matcher emailMatcher = emailPattern.matcher(email.toString());
			if(!emailMatcher.matches())
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação", "E-mail inválido"));
		}
		
	}

}
