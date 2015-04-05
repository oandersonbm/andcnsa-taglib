package br.com.cadernetadigital.component.inputtext.validador.obrigatorio;

import br.com.cadernetadigital.component.inputtext.InputText;
import br.com.cadernetadigital.component.inputtext.validador.Validador;


public class ObrigatorioValidator implements Validador{


	@Override
	public void verifica(InputText input) {
		if(input.getObrigatorio()){
			input.setRequired(true);
			input.setRequiredMessage("Campo obrigatório");
			
		}
	}

}
