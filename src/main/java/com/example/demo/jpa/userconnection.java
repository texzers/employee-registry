package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Users;

@Repository
public interface userconnection extends JpaRepository<Users, Integer> {

}
