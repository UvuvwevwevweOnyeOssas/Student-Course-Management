package iat.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iat.edu.model.Student;
import iat.edu.repostry.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
   @Autowired
   
	private StudentRepository stuRepo;
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return stuRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer stuId) {
		// TODO Auto-generated method stub
     Optional<Student> optionStudent = stuRepo.findById(stuId);
		return optionStudent.get();
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return stuRepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student existingStu= stuRepo.findById(student.getId()).get();
		existingStu.setName(student.getName());
		existingStu.setEmail(student.getEmail());
		Student updateStu= stuRepo.save(existingStu);
		return updateStu;
	}

	@Override
	public void deleteStudent(Integer stuId) {
		// TODO Auto-generated method stub
		stuRepo.deleteById(stuId);
		
	}

}
