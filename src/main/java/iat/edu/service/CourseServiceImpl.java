package iat.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iat.edu.model.Course;
import iat.edu.repostry.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
 @Autowired
 private CourseRepository couRepo;
	@Override
	
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return couRepo.save(course);
	}

	@Override
	public Course getCourseById(Integer couId) {
		// TODO Auto-generated method stub
		Optional<Course> optionStudent = couRepo.findById(couId);
		return optionStudent.get();
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return couRepo.findAll();
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course existingCou= couRepo.findById(course.getId()).get();
		existingCou.setTitle(course.getTitle());
		existingCou.setDescription(course.getDescription());
		existingCou.setCode(course.getCode());
		existingCou.setEndDate(course.getEndDate());
		existingCou.setStartDate(course.getStartDate());
		Course updateCou= couRepo.save(existingCou);
		return updateCou;
	}

	@Override
	public void deleteCourse(Integer couId) {
		// TODO Auto-generated method stub
		couRepo.deleteById(couId);
	}

	@Override
	public Course findByTitle(String title) {
		// TODO Auto-generated method stub
		return couRepo.findByTitle(title);
	}

}
