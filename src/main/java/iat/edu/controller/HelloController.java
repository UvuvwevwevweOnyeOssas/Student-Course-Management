package iat.edu.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
@GetMapping("/hello")
public String handle(Model model) {
	SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMMM yyyy");
	Calendar ca1= Calendar.getInstance();
	model.addAttribute("today", dateFormat.format(ca1.getTime()));
	return "greeting";
		
}


}
