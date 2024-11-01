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

import Stock.models.DemoModel;
import Stock.services.DemoBusinessService;
import Stock.services.DemoBusinessServiceInterface;

@RestController
@RequestMapping("/dataShow")
public class DemoRestController {

    DemoBusinessServiceInterface service;    

    @Autowired
    public DemoRestController(DemoBusinessService service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public List<DemoModel> showAllData(Model model){
        List<DemoModel> dataShow = service.getData();
        return dataShow; 
    }

    @GetMapping("/search/{searchTerm}")
    public List<DemoModel> searchData(@PathVariable(name="searchTerm") String searchTermVar){
        List<DemoModel> dataShow = service.searchData(searchTermVar);
        return dataShow;
    }

    @GetMapping("/{id}")
    public DemoModel getById(@PathVariable(name="id")long id){
        return service.getById(id);
    }

    //parameters comes from Thymeleaf form
    @PostMapping("/")
    public long addData(@RequestBody DemoModel model) {
        return service.addOne(model);    }

  
    @PutMapping("/update/{id}")
    public DemoModel update(@RequestBody DemoModel model,@PathVariable(name="id") long id){
        return service.updateOne(id, model);
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable(name="id") long id){
        return service.deleteOne(id);
    }

  

}
