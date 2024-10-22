package Stock.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stock.models.PieDataModel;
import Stock.services.PieBusinessService;
import Stock.services.PieBusinessServiceInterface;


@RestController
@RequestMapping("/charts")
public class ChartRestController {
	
    PieBusinessServiceInterface pieService;    

    @Autowired
    public ChartRestController(PieBusinessService pieService) {
        super();
        this.pieService = pieService;
    }
	
	@GetMapping("/")	
	public List<PieDataModel> lineChart(Model model) {
		List<PieDataModel> dataShow = pieService.getData();		
		return dataShow;
	}
	
	// @GetMapping("/demoChart")
	// public String LineChartShow(Model model) {
	
	// 	List<Elements> LineElts = new ArrayList<Elements>();
		
	// 	LineElts.add(new Elements("臺灣水泥"));
	// 	LineElts.add(new Elements("亞洲水泥"));
	// 	LineElts.add(new Elements("嘉新水泥"));
	// 	LineElts.add(new Elements("環球水泥"));
	// 	LineElts.add(new Elements("幸福水泥"));
	// 	LineElts.add(new Elements("信大水泥"));
	// 	LineElts.add(new Elements("東南水泥"));
	
	// 	model.addAttribute("Elts",LineElts);
		
	// 	return "pie.html";
	// }
	
	// @GetMapping("/demoJson")
	// @ResponseBody
	// public List<Elements> LineChartJson(Model model) {
	
	// 	List<Elements> LineElts = new ArrayList<Elements>();
		
	// 	LineElts.add(new Elements("臺灣水泥"));
	// 	LineElts.add(new Elements("亞洲水泥"));
	// 	LineElts.add(new Elements("嘉新水泥"));
	// 	LineElts.add(new Elements("環球水泥"));
	// 	LineElts.add(new Elements("幸福水泥"));
	// 	LineElts.add(new Elements("信大水泥"));
	// 	LineElts.add(new Elements("東南水泥"));
	
	// 	model.addAttribute("Elts",LineElts);
		
	// 	return LineElts;
	// }


	// @GetMapping("/pieShow")
	// @ResponseBody
	// public String ShowLineChart(Model model){
	// 	return "pie.html";
	// }

	
	// @GetMapping("/pieShow")
	// public String ShowPieChart(Model model){
	// 	return "pie.html";
	// }

	

}	

