package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/add")
public class empcontroller {

	
	@Autowired
	EmpService empserv;
	
	@PostMapping
	public ResponseEntity<Users> postAddUser(@Valid @RequestBody Users user) {
		return new ResponseEntity<>(empserv.adduser(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Users> getUserAll() {
		return empserv.getuser();
	}
	
	@GetMapping("/{id}")
	public Optional<Users> getUserById(@PathVariable int id )
	{
		return empserv.getbyid(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserByid(@PathVariable int id)
	{
		 empserv.deleteuser(id);
	}
	
	@PutMapping("/{id}")
	public Users updateUser(@PathVariable int id, @RequestBody Users user) {
	    user.setUserid(id); // ✅ Set the ID from the path into the user object
	    return empserv.update(user);
	}

	
	@GetMapping("/search")
	public ResponseEntity<Optional<Users>> getMethodName(@RequestParam int id) {
		return new ResponseEntity<>(empserv.findByNmae(id), HttpStatus.OK);
	}
	
	@GetMapping("/paginated")
	public ResponseEntity<Page<Users>> getMethodName(@RequestParam int page, @RequestParam int size) {
		return new ResponseEntity<>(empserv.getAllPagination(page, size), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Users ExEmployee(@PathVariable int id, @RequestBody Users user) {
	    user.setUserid(id); // ✅ Set the ID from the path into the user object
	    return empserv.update(user);
	}
	
	
}
