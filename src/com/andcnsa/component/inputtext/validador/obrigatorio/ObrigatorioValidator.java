package com.andcnsa.component.inputtext.validador.obrigatorio;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.andcnsa.component.inputtext.InputText;
import com.andcnsa.component.inputtext.validador.Validador;

public class ObrigatorioValidator implements Validator, Validador {

	@Override
	public void verifica(InputText input) {
		System.out.println(input.getObrigatorio());
		if (input.getObrigatorio()) {
			input.addValidator(this);
		}
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object valor) throws ValidatorException {
		if (!valida(valor))
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Informação",
					"Campo obrigatório"));
	}

	private Boolean valida(Object obj) {
		try{
			if (obj.toString().length() > 0)
				return true;
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
