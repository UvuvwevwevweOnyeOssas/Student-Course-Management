package iat.edu.repostry;

import org.springframework.data.jpa.repository.JpaRepository;

import iat.edu.model.CourseRegistration;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {

}
