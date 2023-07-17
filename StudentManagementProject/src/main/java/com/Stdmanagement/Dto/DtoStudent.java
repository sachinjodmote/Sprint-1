package com.Stdmanagement.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Stdmanagement.Entity.Branch;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it creates getter setters
@NoArgsConstructor // it creates no arg constructors
@AllArgsConstructor // it creates parameterised constructor
public class DtoStudent // student dto method
{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dtoid;

	@NotNull
	//@Size(min = 1, max = 15, message = "First Should not be null")
	private String dtofname;

	@NotNull
	//@Size(min = 1, max = 15, message = "Last Should not be null")
	private String dtolname;

	@NotNull
	//@Size(min = 10)
	private String dtomobile;

	@Email
	private String dtoemail;

	@NotNull
	//@Size(min = 50, message = "Address Should be 50 words")
	private String dtoaddr;

	private Branch branch;
	 
}
