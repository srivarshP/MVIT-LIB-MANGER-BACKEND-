package com.mvit.diglib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	public List<Student> listAll(){
		return repo.findAll();
	}
	public void save(Student stud) {
		repo.save(stud);
	}
	public Student get(Integer ID) {
		return repo.findById(ID).get();
	}
	public void delete(Integer ID) {
		repo.deleteById(ID);
	}
	public void update(Student stud) {
		repo.save(stud);
	}
}
