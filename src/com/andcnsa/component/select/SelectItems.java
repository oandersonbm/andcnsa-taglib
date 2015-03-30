package com.andcnsa.component.select;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UISelectItems;

@ResourceDependencies({
		@ResourceDependency(library = "andcnsa", name = "css/bootstrap.min.css"),
		@ResourceDependency(library="andcnsa", name="css/font-awesome.min.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa-fonts.css"),
		@ResourceDependency(library="andcnsa", name="css/andcnsa.css"),
		@ResourceDependency(library = "andcnsa", name = "css/andcnsa-input.css"),
})
public class SelectItems extends UISelectItems{

	@Override
	public String getFamily() {
		return "form";
	}
}
