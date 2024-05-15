package iat.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iat.edu.model.CourseRegistration;
import iat.edu.repostry.CourseRegistrationRepository;

@Service
public class CourseRegServiceImpl implements CourseRegService {
    @Autowired
    CourseRegistrationRepository courseRegRepo;
	@Override
	public void registerCourse(CourseRegistration cr) {
		// TODO Auto-generated method stub
		courseRegRepo.save(cr);
		
	}
	@Override
	public List<CourseRegistration> getAll() {
		// TODO Auto-generated method stub
		return courseRegRepo.findAll();
	}
  
}
