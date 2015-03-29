package com.andcnsa.component.inputtext.validador.obrigatorio;

import com.andcnsa.component.inputtext.InputText;
import com.andcnsa.component.inputtext.validador.Validador;


public class ObrigatorioValidator implements Validador{


	@Override
	public void verifica(InputText input) {
		if(input.getObrigatorio()){
			input.setRequired(true);
			input.setRequiredMessage("Campo obrigatório");
			
		}
	}

}
