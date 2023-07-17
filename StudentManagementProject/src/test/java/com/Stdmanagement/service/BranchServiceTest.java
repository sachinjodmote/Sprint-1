package com.Stdmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.*;
import com.Stdmanagement.Repository.BranchRepository;
import com.Stdmanagement.Service.BranchService;
import com.Stdmanagement.Entity.*;
import com.Stdmanagement.Exception.NotFoundException;

@SpringBootTest
public class BranchServiceTest {

	@MockBean
	BranchRepository repo;
	@MockBean
	BranchService service;

	@Test
	public void testGetAllBranch() {
		Branch br = new Branch();
		br.setId(101);
		br.setBranch("CSE");

		Branch br2 = new Branch();
		br.setId(102);
		br.setBranch("Mech");

		List<Branch> arr = new ArrayList<>();
		arr.add(br);
		arr.add(br2);

		Mockito.when(this.repo.findAll()).thenReturn(arr);

	}

	@Test
	public void testAddBranch() {
		Branch br1 = new Branch();
		br1.setId(103);
		br1.setBranch("Civil");

		Mockito.when(this.repo.save(br1)).thenReturn(br1);

		
	}

	
	 @Test
	 public void testGetById() throws NotFoundException {
		 Branch br=new Branch();
		 br.setId(101);
		 br.setBranch("CSE");
		 
		 Mockito.when(repo.findById(br.getId())).thenReturn(br);
	 }
	  
	 
	@Test
	public void testDelete() {
		Branch br3 = new Branch();
		br3.setId(101);
		br3.setBranch("computer");

		Mockito.when(this.repo.findById(1)).thenReturn(br3);
		Mockito.when(this.repo.existsById(br3.getId())).thenReturn(false);
		assertFalse(this.repo.existsById(br3.getId()));
	}
	
	@Test
	public void testUpdate() {
		Branch br4=new Branch();
		br4.setId(101);
		br4.setBranch("MECH");
		
		Mockito.when(repo.findById(101)).thenReturn(br4);
		br4.setBranch("CSE");
	}

}
