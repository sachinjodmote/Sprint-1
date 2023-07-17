package com.Stdmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Stdmanagement.Converter.StudentConverter;
import com.Stdmanagement.Dto.DtoBranch;
import com.Stdmanagement.Dto.DtoStudent;
import com.Stdmanagement.Entity.Branch;
import com.Stdmanagement.Entity.Student;
import com.Stdmanagement.Exception.AlreadyExistsExceptionFound;
import com.Stdmanagement.Exception.NotFoundException;
import com.Stdmanagement.Repository.StudentRepo;

@Component           // it is used to provide the connection to use the @Autowired the files easily in file.
public class StudentService {
    
	@Autowired                // it automatically provide the connection with student reository
	private StudentRepo srepo;
	
	@Autowired                        // it automatically provide the connection with student convertor
	private StudentConverter sconverter;
	
	
	 // this method is create to fetch all data from database.
	 public  List<DtoStudent> getallStudent(){
	    	List<Student> student=(List<Student>)this.srepo.findAll();
	    	return this.sconverter.entityToDto(student);
	    }
	    
	  //this method fetch data by id
	    public DtoStudent getById(int id) throws NotFoundException {
	    	
	    	Student student=this.srepo.findById(id);
	    			if(student!=null) {
	    	return this.sconverter.entityToDto(student);
	    	}
	    	else {
	    		throw new NotFoundException(id+ " Not found");
	    	}
	    }
	    
	    //this method is for adding details in database
	    public DtoStudent addStudent(DtoStudent student) {
	    	Student st=srepo.findById(student.getDtoid());
	    	if(st==null){
	    	Student s1=this.sconverter.dtoToEntity(student);
	    	Student s2=this.srepo.save(s1);
	    	
	    	return this.sconverter.entityToDto(s2);
	    	}
	    	else throw new AlreadyExistsExceptionFound("Student Details already Exists");	    }
	    
	  //this method is for deleting the data from database by id
	    public String deleteStudent(int id) throws NotFoundException {
	    	Student rt=srepo.findById(id);
	    	
	    	this.srepo.deleteById(id);
	    	return ("Student Deleted"+id);
	    }
	    
	  //this method is for updating data from database by id
	    public DtoStudent updateStudent(DtoStudent sdto, Integer id){
	    	
	    	Student s1=srepo.findById(id).orElseThrow(
	    			() -> new NotFoundException(id+ " No Such Student id Exists"));
	                  
	      s1.setId(sdto.getDtoid());
	      s1.setFname(sdto.getDtofname());
	      s1.setLname(sdto.getDtolname());
	      s1.setMobile(sdto.getDtomobile());
	      s1.setEmail(sdto.getDtoemail());
	      s1.setAddr(sdto.getDtoaddr());
	      
	      this.srepo.save(s1);
	      return this.sconverter.entityToDto(s1);
	      
	    }
	
}
