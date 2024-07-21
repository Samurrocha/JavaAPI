package com.MyFirstAPI.UserRepositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyFirstAPI.entities.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
}