package Stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stock.models.DataModel;
import Stock.services.DataBusinessService;

@RestController
@RequestMapping("/api/v1/dataShow")
public class DataRestController {

    DataBusinessService service;    

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


}
