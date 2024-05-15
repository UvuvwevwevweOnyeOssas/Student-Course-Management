
package iat.edu.model;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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
@Table(name="student")
public class Student {
   public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
@Id 
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;
   @NotBlank(message="name is required")
   @Column(name="name")
   private String name;
   @NotBlank(message="email is required")
   @Pattern(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
   flags = Pattern.Flag.CASE_INSENSITIVE,message="Please provide correct email for")
   @Column(name="email")

   private String email;
   @DateTimeFormat(pattern="MM/dd/yyyy")
   @NotNull @Past(message="Date of Birth should be Past")
   @Column(name="dob")
   private LocalDate birthDate;
   @Size(min=6, message="The length of password must be at least 6 characters")
   @NotBlank(message="Password is required")
   @Column(name="password")
   private String  password;
   @Column(name="gender")
   private String gender;
   
}
