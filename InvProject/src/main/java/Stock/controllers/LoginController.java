package Stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Stock.models.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String displayLoginForm(Model model){
        
        model.addAttribute("loginModel", new LoginModel());

        return "loginForm.html";
    }

    // @PostMapping("/processLogin")
    // public String processLogin(@Valid LoginModel loginModel,BindingResult bindingResult,Model model){
        
    //     if(bindingResult.hasErrors()){
    //         model.addAttribute("loginModel", new LoginModel());
    //         return "loginForm.html";
    //     }

    //     model.addAttribute("loginModel", loginModel);

    //     return "loginResults.html";
    // }

}
