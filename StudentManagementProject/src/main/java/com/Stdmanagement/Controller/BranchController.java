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

import com.Stdmanagement.Dto.DtoBranch;
import com.Stdmanagement.Dto.DtoStudent;
import com.Stdmanagement.Exception.NotFoundException;
import com.Stdmanagement.Service.BranchService;

@RestController            //controller controls api requests
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class BranchController {
	
	@Autowired
	private BranchService service;   //creating service object
	
	
	@GetMapping("/branch")       //get mapping request for view all branch details
	public ResponseEntity<List<DtoBranch>> getAll(){
		
		return ResponseEntity.ok(service.getallbranch());   //calling getall branch from service class
		
	}
	
	@GetMapping("branch/getbyid/{id}")      //get mapping for view data by id
	public ResponseEntity<DtoBranch> getById(@PathVariable("id") int id) throws NotFoundException{
		return ResponseEntity.ok(service.getById(id));             //calling getbyid method from service class
		
	}
	
	@PostMapping("branch/add")          //post mapping for adding data
	public ResponseEntity<DtoBranch> addBranch(@Valid @RequestBody DtoBranch dto){
		DtoBranch sdto=this.service.addbranch(dto);                        //calling addbranch method 
		return new ResponseEntity<>(sdto, HttpStatus.CREATED);     
	}
	
	@DeleteMapping("branch/delete/{id}")                  //delete mapping for delete details by id
	public ResponseEntity<String> deleteBranch(@PathVariable("id") int id){
		
		service.deleteBranch(id);                             //calling delete method
		return ResponseEntity.ok("Branch deleted successfully !");
		
	}
	@PutMapping("branch/update/{id}")              //update mapping for update details by id
	public DtoBranch updateBranch(@RequestBody DtoBranch sdto, @PathVariable("id")int id){
		
		return service.updateBranch(sdto, id);       //calling update method
	}

}
