package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.userconnection;

@Service
public class EmpService {
	@Autowired
	userconnection connection;
	
	public Users adduser(Users user) {
		return connection.save(user);
	}
	
	public List<Users> getuser(){
		return connection.findAll();
	}
	
	public Optional<Users> getbyid(int userid){
		return connection.findById(userid);
	}
	
	public void deleteuser(int userid) {
		connection.deleteById(userid);
	}
	
	public Users update(Users user) {
		return connection.save(user);
	}
	
	public Optional<Users> findByNmae(int id) {
		return connection.findById(id);
	}
	
	public Page<Users> getAllPagination(int page , int size)
	{
		PageRequest pageble = PageRequest.of(page, size);
		return connection.findAll(pageble);
	}
	

}
