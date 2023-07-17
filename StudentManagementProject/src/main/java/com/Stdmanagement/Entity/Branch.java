package com.Stdmanagement.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity   //it creates table in database
@Data    //it creates getter setters
public class Branch {
	
	@Id                                                  //it used to assign primary key table in database
	@NotNull(message="ID cant be null")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;                                            //variable declaration
	
	@NotNull(message="Please Enter Branch Name")
	private String branch;                             //variable declaration
	
	
	  @OneToMany(mappedBy="branch") // it used to mapped the tables like OneToOne.
	  @JsonManagedReference // It is used to managed the response given fromPostman / Browser.
	  private List<Student> Student;
}
