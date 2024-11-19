package Stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class PieController {

    
    @GetMapping("/pie")
    public String displayPieChart(Model model){        

        return "pieNbar.html";
    }

    @GetMapping("/line")
    public String displayLineChart(Model model){        

        return "line.html";
    }
  

 
}
