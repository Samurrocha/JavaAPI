package com.MyFirstAPI.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MyFirstAPI.entities.Users;
import java.util.List;




@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	List<Users> findByNameContainingAllIgnoreCase(String part);
	
	
}