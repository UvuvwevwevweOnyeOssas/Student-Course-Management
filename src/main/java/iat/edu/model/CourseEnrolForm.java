package iat.edu.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseEnrolForm {
  private String id;
  private String title;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
  
}
