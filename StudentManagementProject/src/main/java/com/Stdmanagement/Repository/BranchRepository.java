package com.Stdmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Stdmanagement.Entity.Branch;
//it acts as translator java code to sql
//this jpa repository where all crude operation perform

public interface BranchRepository extends JpaRepository<Branch, Integer> {

	public Branch findById(int id);
}
