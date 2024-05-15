package iat.edu.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import iat.edu.model.Course;
import iat.edu.model.CourseEnrolForm;
import iat.edu.model.CourseRegistration;
import iat.edu.model.Student;
import iat.edu.service.CourseRegService;
import iat.edu.service.CourseService;
import iat.edu.service.StudentService;


@Controller
public class CourseRegistrationController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseRegService couRegService;
	
	
	@GetMapping("/coursemgt/allEnroll")
	public String viewAllEnrols(Model model)
	{
		List<CourseRegistration> enrols= couRegService.getAll();
		model.addAttribute("enrols",enrols);
		return "courses-enrols";
	}
	
	
	
	
	@GetMapping("/coursemgt/courseRegister")
	 public String viewCourseRegisterForm(Model model){

		List<Course> courses=courseService.getAllCourses();
		List<String>titles=new ArrayList<>();
		courses.forEach(course -> titles.add(course.getTitle()));
		List<Student> students= studentService.getAllStudents();
		List<String> ids=new ArrayList<>();
		students.forEach(student->ids.add(student.getId().toString()));
		model.addAttribute("ids",ids);
		model.addAttribute("titles",titles);
		return "course-register";
		 
	 }
	 @PostMapping("/coursemgt/courseRegSave")
	 public String saveCourseEnrol(@ModelAttribute("courseEnrolForm")CourseEnrolForm courseEnrolForm,BindingResult result,Model model)
{
		 if(result.hasErrors()) {
			 return "course-register";
		 }
		 SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		 LocalDateTime today=LocalDateTime.now();
		 Course course=courseService.findByTitle(courseEnrolForm.getTitle());
		 Student student=studentService.getStudentById(Integer.parseInt (courseEnrolForm.getId()));
		 
		 CourseRegistration courseReg=new CourseRegistration();
		 courseReg.setCourse(course);
		 courseReg.setGrade(0);
		 courseReg.setRegisteredAt(today);
		 courseReg.setStudent(student);
		 
		 couRegService.registerCourse(courseReg);
	return "redirect:/coursemgt/allEnroll";
	
}
}

