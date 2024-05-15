package iat.edu.repostry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iat.edu.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	public Course findByTitle(String title);

}
