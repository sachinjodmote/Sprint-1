package com.Stdmanagement.Converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Stdmanagement.Dto.DtoBranch;
import com.Stdmanagement.Entity.Branch;

@Component //it provides connecton to @autowired files
public class BranchConverter {

	public DtoBranch entityToDto(Branch x) //this method is for convert entity to dto
	{
		
		DtoBranch dto=new DtoBranch();  //creting object of dtobranch
		
		dto.setDtoid(x.getId());             // setfield
		dto.setDtobranch(x.getBranch());         // setfield
		
		dto.setStudent(x.getStudent());     
		return dto;    //return dto object
		}
	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<DtoBranch> entityToDto(List<Branch> branch){
		
		return branch.stream().map(x->entityToDto(x)).collect(Collectors.toList()); //converts all object
	}
	
	//this method is for convert dto to Entity
	public Branch dtoToEntity(DtoBranch dto) {
		
		Branch branch=new Branch();        //creting object of branch
		
		branch.setId(dto.getDtoid());         //setfields
		branch.setBranch(dto.getDtobranch());      //setfields
		branch.setStudent(dto.getStudent());
		 return branch;        //return branch object 
	}
	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<Branch> dtoToEntity(List<DtoBranch> dtobranch){
		return  dtobranch.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList()); //converts all object
	}
}
