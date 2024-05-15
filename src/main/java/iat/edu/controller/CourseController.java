package iat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import iat.edu.model.Course;

import iat.edu.service.CourseService;
import iat.edu.validator.CourseValidator;
import jakarta.validation.Valid;

@Controller
public class CourseController {
	@Autowired
	CourseService couService;
	@Autowired
	private CourseValidator courseValidator;
	@InitBinder("course")
	private void initCourseBinder(WebDataBinder binder) {
		binder.addValidators(courseValidator);
	}
	
	@GetMapping("/coursemgt/courses")
	public String viewHomePage(Model model) {
		List<Course>listCourses = couService.getAllCourses();
		model.addAttribute("listCourses",listCourses);
		return "courses";
				
		}
	@GetMapping("/coursemgt/newCourse")
	public String showCourseForm(Model model) {
		Course course=new  Course();
		model.addAttribute("course",course);
		return "course-new";
	}
	
	@PostMapping("/coursemgt/registerCourse")
	public String saveCourse(@ModelAttribute @Valid Course course,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "course-new";
		}
		couService.createCourse(course);
		return "redirect:/coursemgt/courses";
	}
	@GetMapping("/coursemgt/editCourse/{id}")
	public ModelAndView showCourseUpdateForm(@PathVariable ("id")Integer id,Model model) {
		ModelAndView mav= new ModelAndView("course-update");
       Course course = couService.getCourseById(id);
       mav.addObject(course);
		return mav;
	}
	@PostMapping("/coursemgt/updateCourse/{id}")
	public String updateCourse(@PathVariable ("id")Integer id,@Validated Course course,
			BindingResult result,Model model) {
		if (result.hasErrors()) {
			course.setId(id);
		
		return "course-update";
	}
	couService.updateCourse(course);
	return "redirect:/coursemgt/courses";
	}
	
	@GetMapping("/coursemgt/deleteCourse/{id}")
	public String deleteCourse(@PathVariable(name="id")Integer id) {
		couService.deleteCourse(id);
		
		return "redirect:/coursemgt/courses";
	}
}
