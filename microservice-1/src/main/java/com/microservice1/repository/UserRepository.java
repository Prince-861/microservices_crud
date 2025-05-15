package com.microservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice1.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
