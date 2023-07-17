package com.Stdmanagement.Dto;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.Stdmanagement.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // for creating getter setter
@NoArgsConstructor // it generates no argument constructor
@AllArgsConstructor // it generates parameterized constructor
public class DtoBranch // dto branch method
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dtoid; // variable initializing

	@NotNull(message = "Please Enter Branch Name") // constaints validation
	private String dtobranch; // variable initializing

	
	private List<Student> Student; // creating list student object
}
