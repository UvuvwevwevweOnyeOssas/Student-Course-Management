package iat.edu.service;

import java.util.List;

import iat.edu.model.CourseRegistration;

public interface CourseRegService {
 void registerCourse(CourseRegistration cr);
 List<CourseRegistration> getAll();
}
