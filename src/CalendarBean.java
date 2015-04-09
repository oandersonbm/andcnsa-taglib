import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.cadernetadigital.component.calendar.model.CalendarModel;


@ManagedBean
@SessionScoped
public class CalendarBean {
	private CalendarModel calendar;
	
	@PostConstruct
	public void init(){
		calendar = new CalendarModel();
		calendar.setTitulo("Nenhum");
	}
	public void salva(){
		System.out.println("Salvando... ou não... Aqui vou eu!");
		System.out.println(getCalendar().getTitulo());
	}

	public CalendarModel getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarModel calendar) {
		this.calendar = calendar;
	}
	
}
