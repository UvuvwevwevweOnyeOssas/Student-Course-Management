package iat.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iat.edu.model.Course;

@Component
public class CourseValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Course course=(Course)target;
		if((course.getStartDate()!=null&& course.getEndDate()!=null)&&
				(course.getStartDate().compareTo(course.getEndDate())>0)) {
			errors.reject("startDate","end date should be greater than start date.");
			errors.rejectValue("endDate","error.dates" ,"end date must be > start date.");
		}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.startDate","Start Date is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "error.endDate","End Date is required.");
			
		}
			
	}


