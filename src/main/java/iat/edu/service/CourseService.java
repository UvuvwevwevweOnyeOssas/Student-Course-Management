package iat.edu.service;

import java.util.List;

import iat.edu.model.Course;


public interface CourseService {
	Course createCourse(Course course);
	 Course getCourseById (Integer couId);
	 List<Course> getAllCourses();
	 Course updateCourse(Course course);
	 void deleteCourse (Integer couId);
	 Course findByTitle(String title);
}
