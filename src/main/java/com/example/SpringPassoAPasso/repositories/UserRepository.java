package com.example.SpringPassoAPasso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPassoAPasso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
