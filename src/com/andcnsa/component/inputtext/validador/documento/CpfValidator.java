package com.andcnsa.component.inputtext.validador.documento;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.andcnsa.component.inputtext.InputText;
import com.andcnsa.component.inputtext.validador.Validador;

public class CpfValidator implements Validator, Validador {
	
	@Override
	public void verifica(InputText input) {
		if(input.getTipo().equals("documento")){
			input.setTipo("text");
			input.addValidator(this);
		}
		
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object cpf) throws ValidatorException {
		if(!valida(cpf))
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação", "Documento inválido"));
	}
	private Boolean valida(Object obj){
		if(obj != null){
			if(obj.toString().length() > 0 && obj.toString().length() < 11)
				return false;
			if((obj instanceof String) && obj.toString().length() == 11){
				try {
	
					String cpf = obj.toString();
					Integer dv1 = null;
					Integer dv2 = null;
					//ETAPA 1: multiplicação dos 9 primeiros caracteres por (10-i) e soma
					Double valor = 0d;
					for(int i = 0; i < (cpf.length()-2); i++){
						valor += Character.getNumericValue(cpf.charAt(i))*(10-i);
					}
					
					//Encontrando o DV1
					valor = valor%11;
					if(valor < 2)
						dv1 = 0;
					else
						dv1 = 11-valor.intValue();
					if( dv1 != Character.getNumericValue( cpf.charAt(9) ) ){
						return false;
					}
					
					//Encontrando o DV2
					valor = 0d;
					for(int i = 0; i < (cpf.length()-1); i++){
						valor += Character.getNumericValue(cpf.charAt(i))*(11-i);
					}
					valor = valor%11;
					if(valor < 2)
						dv2 = 0;
					else
						dv2 = 11-valor.intValue();
					if( dv2 != Character.getNumericValue( cpf.charAt(10) ) ){
						return false;
					}
				} catch (Exception e) {
	
				}
			}else{
			}
		}
		return true;
	}
}
