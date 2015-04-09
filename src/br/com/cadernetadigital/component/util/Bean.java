package br.com.cadernetadigital.component.util;

import javax.faces.context.FacesContext;

public class Bean {
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
		if(beanName != null){
			FacesContext context = FacesContext.getCurrentInstance();
		    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
		}else{
			return null;
		}
	}
}
