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

import Stock.models.DataModel;
import Stock.services.DataBusinessService;
import Stock.services.DataBusinessServiceInterface;

@RestController
@RequestMapping("/dataShow")
public class DataRestController {

    DataBusinessServiceInterface service;    

    @Autowired
    public DataRestController(DataBusinessService service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public List<DataModel> showAllData(Model model){
        List<DataModel> dataShow = service.getData();
        return dataShow; 
    }

    @GetMapping("/search/{searchTerm}")
    public List<DataModel> searchData(@PathVariable(name="searchTerm") String searchTermVar){
        List<DataModel> dataShow = service.searchData(searchTermVar);
        return dataShow;
    }

    @GetMapping("/{id}")
    public DataModel getById(@PathVariable(name="id")long id){
        return service.getById(id);
    }

    //parameters comes from Thymeleaf form
    @PostMapping("/")
    public long addData(@RequestBody DataModel model) {
        return service.addOne(model);    }

  
    @PutMapping("/update/{id}")
    public DataModel update(@RequestBody DataModel model,@PathVariable(name="id") long id){
        return service.updateOne(id, model);
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable(name="id") long id){
        return service.deleteOne(id);
    }

  

}
