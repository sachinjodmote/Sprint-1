package com.Stdmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Stdmanagement.Entity.Student;

//it acts as translator java code to sql
//this jpa repository where all crude operation perform
public interface StudentRepo extends JpaRepository<Student, Integer> {
	public Student findById(int id);

	
}
