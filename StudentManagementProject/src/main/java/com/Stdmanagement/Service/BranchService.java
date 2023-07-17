package com.Stdmanagement.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Stdmanagement.Converter.BranchConverter;
import com.Stdmanagement.Dto.DtoBranch;
import com.Stdmanagement.Entity.Branch;
import com.Stdmanagement.Exception.NotFoundException;
import com.Stdmanagement.Repository.BranchRepository;

@Component         // it is used to provide the connection to use the @Autowired the files easily in file.
public class BranchService {
   
	@Autowired        // it automatically provide the connection with branch reository
	private BranchRepository brepo;
	 
    @Autowired         // it automatically provide the connection with branch convertor
	private BranchConverter bconverter;
    
 // this method is create to fetch all data from database.
    public  List<DtoBranch> getallbranch(){
    	List<Branch> branch=(List<Branch>)this.brepo.findAll();
    	return this.bconverter.entityToDto(branch);
    }
    
    //this method fetch data by id
    public DtoBranch getById(int id) throws NotFoundException {
    	Branch br=this.brepo.findById(id);
    	if(br!=null) {
    	  return this.bconverter.entityToDto(br);
    	}
    	else {
    		throw new NotFoundException(id+ " Not Found");
    	}
    }
    
    //this method is for adding details in database
    public DtoBranch addbranch(DtoBranch branch) {
    	
    	
    	Branch b1=this.bconverter.dtoToEntity(branch);
    	Branch b2=this.brepo.save(b1);
    	
    	return this.bconverter.entityToDto(b2);
  
    }
    
    //this method is for deleting the data from database by id
    public String deleteBranch(int id) throws NotFoundException {
    	    	
    	this.brepo.deleteById(id);
    	return ("Branch Deleted"+id);
    }
    
    //this method is for updating data from database by id
    public DtoBranch updateBranch(DtoBranch bdto, int id){
                  
      Branch b1=this.brepo.findById(id);
    		  
      
      b1.setId(bdto.getDtoid());
      b1.setBranch(bdto.getDtobranch());
      
      this.brepo.save(b1);
      return this.bconverter.entityToDto(b1);
      
    }
}
