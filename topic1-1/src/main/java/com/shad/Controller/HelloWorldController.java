package com.shad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloworld() {
		return("this is hello controller");
	}
	
	
	@GetMapping("/hello2")
	public String showhello(Model model) {
		model.addAttribute("message","showhello function and Model model appled");
		model.addAttribute("rating",100);
		model.addAttribute("report","here is the 3rd line in span");
		return("hellopage.html");
	}
	
	@GetMapping("/hello3")
	public ModelAndView modelhello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","take off model and insert mv");
		mv.addObject("rating",150);
		mv.setViewName("hellopage.html");
		return mv;
	}
	
	@GetMapping("/hello4")
	public String urlhello(@RequestParam("message") String urlmessage,Model model) {	
		model.addAttribute("message",urlmessage);
		model.addAttribute("rating",500);
		model.addAttribute("report","this is the controller u can type something in url");
		return("hellopage");
	}
	
}
