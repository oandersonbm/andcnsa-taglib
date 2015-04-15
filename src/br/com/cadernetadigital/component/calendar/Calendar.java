package br.com.cadernetadigital.component.calendar;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import br.com.cadernetadigital.component.calendar.model.CalendarModel;
import br.com.cadernetadigital.component.util.Bean;

@ResourceDependencies({
	@ResourceDependency(library="andcnsa", name="css/bootstrap.min.css"),
	@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
	@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
	@ResourceDependency(library="andcnsa", name="js/jquery.min.js"),
	@ResourceDependency(library="andcnsa", name="js/moment.js"),
	@ResourceDependency(library="andcnsa", name="css/fullcalendar.min.css"),
	@ResourceDependency(library="andcnsa", name="js/fullcalendar.min.js"),
	@ResourceDependency(library="andcnsa", name="js/fullcalendar.pt-br.js")
})
public class Calendar extends UIInput{
	
	private enum Propriedades{
		save, bean
	}
	public void setSave(Boolean arg1){
		getStateHelper().put(Propriedades.save, arg1);
	}
	public Boolean getSave(){
		return (Boolean)getStateHelper().eval(Propriedades.save, false);
	}
	public void setBean(String arg1){
		getStateHelper().put(Propriedades.bean, arg1);
	}
	public String getBean(){
		return (String)getStateHelper().eval(Propriedades.bean, null);
	}
	public CalendarModel getModel(){
		return (CalendarModel)Bean.findBean(getBean());
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException{
		ResponseWriter out = context.getResponseWriter();
		out.write("<div id='"+getClientCalendarId()+"' class='save-"+getSave()+"'>");
		out.write("</div>");
		out.write("<input name='"+getClientId(context)+".titulo' type='hidden' />");
		super.encodeBegin(context);
	}
	
	@Override
	public void encodeEnd(FacesContext context) throws IOException{
		super.encodeEnd(context);
		ResponseWriter out = context.getResponseWriter();
		out.write("<script>");
		out.write("$(document).ready(function(){ "
				+ "$('#"+getClientCalendarId()+"').fullCalendar({"+getConfig()+"});"
				+ "});");
		out.write("</script>");
	}
	
	@Override
	public void decode(FacesContext context){
		if(getSave()){
			Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
			String t = getClientId(context)+".titulo";
			getModel().setTitulo(requestMap.get(t));
			
			super.decode(context);
		}
	}
	
	
	
	public String getClientCalendarId(){
		try {
			String[] c = super.getClientId().split(":");
			return c[1];			
		} catch (Exception e) {
			return super.getClientId();
		}
	}
	
	private String getConfig(){
		String lang = "lang: 'pt-br'";
		String header = ",header: {left: 'prev,next today',center: 'title',right: 'month,agendaWeek,agendaDay'}";
		String select = "";
		if(getSave()){
			select = ",selectable: true,	"
					+ "selectHelper: true,	"
					+ "select: function(start, end) { "
						+ "var title = prompt('Event Title:');"
						+ "var eventData;"
						+ "if (title) {"
							+ "eventData = {title: title,start: start,end: end};"
							+ "$('input[name$=\""+getClientCalendarId()+".titulo\"]').val(title);"
							+ "$('#"+getClientCalendarId()+"').closest('form').submit();"
							+ "$('#"+getClientCalendarId()+"').fullCalendar('renderEvent', eventData, true);"
						+ "}"
						+ "$('#calendar').fullCalendar('unselect');"
					+ "}";
		}
		return lang+header+select;
	}

}
