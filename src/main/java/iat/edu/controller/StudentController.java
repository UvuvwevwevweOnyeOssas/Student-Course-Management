package iat.edu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import iat.edu.model.Student;
import iat.edu.service.StudentService;
import jakarta.validation.Valid;

@Controller

public class StudentController {
	@Autowired
	StudentService stuService;
	@GetMapping({"/coursemgt","/coursemgt/students"})
	public String viewHomePage(Model model) {
		List<Student>listStudents = stuService.getAllStudents();
		model.addAttribute("listStudents",listStudents);
		return "students";
				
		}
	
	@GetMapping("/coursemgt/newStudent")
	public String showStudentForm(Model model) {
		Student student=new  Student();
		model.addAttribute("student", student);
		return "student-new";
	}
	
	@PostMapping("/coursemgt/registerStudent")
	public String saveStudent(@ModelAttribute @Valid Student student,BindingResult result,Model model) {
		System.out.println("hello save student ====");
		if(result.hasErrors()) {
			return "student-new";
		}
		stuService.createStudent(student);
		return "redirect:/coursemgt/students";
	}
	@GetMapping("/coursemgt/editStudent/{id}")
	public ModelAndView showStudentUpdateForm(@PathVariable ("id")Integer id,Model model) {
		ModelAndView mav= new ModelAndView("student-update");
       Student student = stuService.getStudentById(id);
       mav.addObject(student);
		return mav;
	}
	@PostMapping("/coursemgt/updateStudent/{id}")
	public String updateStudent(@PathVariable ("id")Integer id,@Validated Student student,
			BindingResult result,Model model) {
		if (result.hasErrors()) {
			student.setId(id);
		
		return "student-update";
	}
	stuService.updateStudent(student);
	return "redirect:/coursemgt/students";
	}
	
	@GetMapping("/coursemgt/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(name="id")Integer id) {
		stuService.deleteStudent(id);
		
		return "redirect:/coursemgt/students";
	}
	
}


