package com.Stdmanagement.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Stdmanagement.Entity.Student;
import com.Stdmanagement.Exception.NotFoundException;
import com.Stdmanagement.Repository.StudentRepo;
import com.Stdmanagement.Service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	

	@MockBean StudentRepo repo;
	@MockBean StudentService service;

	@Test
	public void testGetAllStudent() {
		Student st = new Student();
		st.setId(101);
		st.setFname("S");
		st.setLname("J");
		//st.setDob("20/07/1999");
        st.setMobile("9623335791");
        st.setEmail("s@gmail.com");
        st.setAddr("Mandrup");

		List<Student> arr = new ArrayList<>();
		arr.add(st);
		arr.add(st);

		Mockito.when(this.repo.findAll()).thenReturn(arr);

	}

	@Test
	public void testAddStudent() {
		Student st1 = new Student();
		st1.setId(101);
		st1.setFname("S");
		st1.setLname("J");
		//st1.setDob("20/07/1999");
        st1.setMobile("9623335791");
        st1.setEmail("s@gmail.com");
        st1.setAddr("Mandrup");
		Mockito.when(this.repo.save(st1)).thenReturn(st1);

		// assertThat(this.StudentService.addStudent(dpm)).isEqualTo(dpm);
	}

	
	 @Test
	 public void testGetById() throws NotFoundException {
		 Student st=new Student();
		 st.setId(101);
			st.setFname("S");
			st.setLname("J");
			//st.setDob("20/07/1999");
	        st.setMobile("9623335791");
	        st.setEmail("s@gmail.com");
	        st.setAddr("Mandrup");
		 
		 Mockito.when(repo.findById(101)).thenReturn(st);
	 }
	  
	 
	@Test
	public void testDelete() {
		Student st3 = new Student();
		 st3.setId(101);
			st3.setFname("S");
			st3.setLname("J");
			//st3.setDob("20/07/1999");
	        st3.setMobile("9623335791");
	        st3.setEmail("s@gmail.com");
	        st3.setAddr("Mandrup");
		Mockito.when(this.repo.findById(1)).thenReturn(st3);
		Mockito.when(this.repo.existsById(st3.getId())).thenReturn(false);
		assertFalse(this.repo.existsById(st3.getId()));
	}
	
	@Test
	public void testUpdate() {
		Student st4=new Student();
		 st4.setId(101);
			st4.setFname("S");
			st4.setLname("J");
			//st4.setDob("20/07/1999");
	        st4.setMobile("9623335791");
	        st4.setEmail("s@gmail.com");
	        st4.setAddr("Mandrup");
		
		Mockito.when(repo.findById(101)).thenReturn(st4);
		 st4.setId(101);
			st4.setFname("SS");
			st4.setLname("J");
			//st4.setDob("21/07/1999");
	        st4.setMobile("9921385015");
	        st4.setEmail("s@gmail.com");
	        st4.setAddr("Mandrup");
	}


}
