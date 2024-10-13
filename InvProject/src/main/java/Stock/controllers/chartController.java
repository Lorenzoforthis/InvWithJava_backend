package Stock.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Stock.models.Elements;

@Controller
public class chartController {
	
	@GetMapping("/chart")	
	public String lineChart() {
		return "pie_line";
	}
	
	@GetMapping("/demoChart")
	public String LineChartShow(Model model) {
	
		List<Elements> LineElts = new ArrayList<Elements>();
		
		LineElts.add(new Elements("臺灣水泥"));
		LineElts.add(new Elements("亞洲水泥"));
		LineElts.add(new Elements("嘉新水泥"));
		LineElts.add(new Elements("環球水泥"));
		LineElts.add(new Elements("幸福水泥"));
		LineElts.add(new Elements("信大水泥"));
		LineElts.add(new Elements("東南水泥"));
	
		model.addAttribute("Elts",LineElts);
		
		return "pie.html";
	}
	
	@GetMapping("/demoJson")
	@ResponseBody
	public List<Elements> LineChartJson(Model model) {
	
		List<Elements> LineElts = new ArrayList<Elements>();
		
		LineElts.add(new Elements("臺灣水泥"));
		LineElts.add(new Elements("亞洲水泥"));
		LineElts.add(new Elements("嘉新水泥"));
		LineElts.add(new Elements("環球水泥"));
		LineElts.add(new Elements("幸福水泥"));
		LineElts.add(new Elements("信大水泥"));
		LineElts.add(new Elements("東南水泥"));
	
		model.addAttribute("Elts",LineElts);
		
		return LineElts;
	}


	@GetMapping("/lineShow")
	public String ShowLineChart(Model model){
		return "line.html";
	}
}	

