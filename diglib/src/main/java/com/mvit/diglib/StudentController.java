package com.mvit.diglib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class StudentController {
	@Autowired
	private StudentService stud;
	@GetMapping("/studentservice")
	public List<Student> list()
	{
		return stud.listAll();
	} 
	@PostMapping("/studentservice")
	public void add(@RequestBody Student stu1) {
		stud.save(stu1);
	}
	@GetMapping("/studentservice/{ID}")
	public ResponseEntity<Student> get(@PathVariable Integer ID)
	{
		try {
			Student s=stud.get(ID);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
		catch(NoResultException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	} 
	@DeleteMapping("/studentservice/{ID}")
	public void delete(@PathVariable Integer ID) {
		stud.delete(ID);
	}
	@PutMapping("/studentservice/{ID}")
	public ResponseEntity<Student> update(@PathVariable Integer ID,@RequestBody Student update_s)
	{
		try {
			Student exist_s=stud.get(ID);
			exist_s.setName(update_s.getName());
			exist_s.setYear(update_s.getYear());
			exist_s.setBook(update_s.getBook());
			stud.update(exist_s);
			return new ResponseEntity<Student>(exist_s,HttpStatus.OK);
		}
		catch(NoResultException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	} 
}

