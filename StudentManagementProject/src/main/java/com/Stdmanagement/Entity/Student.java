package com.Stdmanagement.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity          //it creates table in database
@Data             //it creates getter setters
@NoArgsConstructor          //it creates no arg constructors
@AllArgsConstructor           //it creates parameterized constructor
public class Student  //student entity/table name
{
	
	@Id           //it used to assign primary key table in database
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;                            ////variable declaration
    
	@NotNull
	//@Size(min = 1, max = 15, message="First Should not be null" )
	private String fname;                    //variable declaration
	
	//@NotNull@Size(min = 1, max = 15, message="Last Should not be null")
	private String lname;                  //variable declaration
	
	@NotNull
	//@Size(min=10)
	private String mobile;              //variable declaration
	
	@Email
	private String email;                 //variable declaration
	
	@NotNull
	//@Size(min=50, message="Address Should be 50 words")
	private String addr;                    //variable declaration
	 

	
	  @ManyToOne(cascade = CascadeType.ALL) // it is used to ManyToOne Mapping orjoin the 2 tables.
	  @JsonBackReference // it is used get Reference back from the browser/Postman. 
	  private Branch branch; // create a Department object
	 
}
