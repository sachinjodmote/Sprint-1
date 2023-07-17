package com.Stdmanagement.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Stdmanagement.Dto.DtoStudent;
import com.Stdmanagement.Entity.Student;

@Component  //it provides connecton to @autowired files
public class StudentConverter {
	
	// This Method is created to convert Entity Class into Dto class.
	public DtoStudent entityToDto(Student student){
		
		DtoStudent dto=new DtoStudent();  //creting object of stostudent
		
		
		dto.setDtoid((int) student.getId());     //SetFields
		dto.setDtofname(student.getFname());       //SetFields
		dto.setDtolname(student.getLname());          //SetFields
		dto.setDtomobile(student.getMobile());         //SetFields
		dto.setDtoemail(student.getEmail());              //SetFields
		dto.setDtoaddr(student.getAddr());          //SetFields
		
		dto.setBranch(student.getBranch());         //SetFields
		return dto;        //return dto 
	}

	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<DtoStudent> entityToDto(List<Student> student){
		return student.stream().map(x-> entityToDto(x)).collect(Collectors.toList());    //converts all object
	}
	// This Method is created to convert dto Class into Entity class.
	public Student dtoToEntity(DtoStudent dtostudent) {
		
		Student stud=new Student();     //creting object of stostudent
		
		stud.setId(dtostudent.getDtoid());          //SetFields
		stud.setFname(dtostudent.getDtofname());      //SetFields
		stud.setLname(dtostudent.getDtolname());      //SetFields
		stud.setMobile(dtostudent.getDtomobile());    //SetFields
		stud.setEmail(dtostudent.getDtoemail());      //SetFields
		stud.setAddr(dtostudent.getDtoaddr());         //SetFields
		stud.setBranch(dtostudent.getBranch());      //SetFields
		return stud;      //return stud object
	} 
	// This Method is created to convert List of dto Class into List of Entity class.
	public List<Student> dtoToEntity(List<DtoStudent> student){
		return  student.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());  //converts all object
	}
}
