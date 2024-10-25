package Stock.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    
    @GetMapping("/{id}")
    public PieDataModel getById(@PathVariable(name="id")long id){
        return pieService.getById(id);
    }
	
	@GetMapping("/search/{searchTerm}")
    public List<PieDataModel> searchData(@PathVariable(name="searchTerm") String searchTermVar){
        List<PieDataModel> dataShow = pieService.searchData(searchTermVar);

        return dataShow;
    }

    
    @PostMapping("/")
    public long addOne(@RequestBody PieDataModel model){
        return pieService.addOne(model);
    }

     
    @PutMapping("/update/{id}")
    public PieDataModel updateOne(@RequestBody PieDataModel model,@PathVariable(name="id") long id){
        return pieService.updateOne(id, model);
    }

    @PostMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable(name="id")long id){
        return pieService.deleteOne(id);
    }
}	

