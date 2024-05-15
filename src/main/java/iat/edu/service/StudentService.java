package iat.edu.service;

import java.util.List;

import iat.edu.model.Student;

public interface StudentService {
 Student createStudent(Student student);
 Student getStudentById (Integer stuId);
 List<Student> getAllStudents();
 Student updateStudent(Student student);
 void deleteStudent (Integer stuId);
}
