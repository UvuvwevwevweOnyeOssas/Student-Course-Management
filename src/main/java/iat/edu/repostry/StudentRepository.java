package iat.edu.repostry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iat.edu.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
