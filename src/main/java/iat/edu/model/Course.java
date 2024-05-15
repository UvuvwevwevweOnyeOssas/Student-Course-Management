
package iat.edu.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="course")
public class Course {
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public List<Course> getMyCourses() {
		return myCourses;
	}
	public void setMyCourses(List<Course> myCourses) {
		this.myCourses = myCourses;
	}
@Id 
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
 @NotBlank(message="Title is required")
 @Column(name="title")
  private String title;
 @Column(name="description")
  private String description;
 @NotBlank(message="Course is required")
 @Size(min=4, message="The length of password must be at least 4 characters")
 @Column(name="code")
 private String code;
 
 @Column(name="start_Date")
 private LocalDate startDate;
 
 @Column(name="end_Date")
 private LocalDate endDate;
 @ManyToMany 
 @JoinTable(name="course_registration",
 joinColumns=@JoinColumn(name="student_id"),
 inverseJoinColumns=@JoinColumn(name="course_id"))

 private List<Course>myCourses;
}
