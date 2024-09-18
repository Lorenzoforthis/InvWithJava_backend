package Stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class chartController {
	
	@GetMapping("/chart")	
	public String lineChart() {
		return "pie_line";
	}
	
}

