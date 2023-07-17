package com.Stdmanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stdmanagement.Dto.DtoStudent;
import com.Stdmanagement.Exception.NotFoundException;
import com.Stdmanagement.Service.StudentService;

@RestController //controller controls api requests by postman/browser
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService service;     //creating service class object
	
	
	@GetMapping("/student")          //get mapping for view all data
	public ResponseEntity<List<DtoStudent>> getAll(){
		
		return ResponseEntity.ok(service.getallStudent());    //calling getallstudent method
	 	
	}
	
	
	@GetMapping("getbyid/{id}")          //get Mapping for view details by id
	public ResponseEntity<DtoStudent> getById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.getById(id));                 //calling method getById
		
	}
	
	
	@PostMapping("student/add")     //post mapping for adding details 
	public ResponseEntity<DtoStudent> addStudent(@Valid @RequestBody DtoStudent dto){
		DtoStudent sdto=this.service.addStudent(dto);                   //calling method addstudent
		return new ResponseEntity<>(sdto, HttpStatus.CREATED);    //retuns https status
	}
	
	@DeleteMapping("delete/{id}")            //delete mapping for delete details by id
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		
		service.deleteStudent(id);         //calling methods
		return ResponseEntity.ok("Student details deleted successfully !");  //retun the message afetr deletion
		
	}
	
	@PutMapping("update/{id}")       //put Mapping for update details by id
	public DtoStudent updateStudent(@RequestBody DtoStudent sdto, @PathVariable("id")Integer id){
		
		return service.updateStudent(sdto, id);    //calling method update student
	}
	

}
