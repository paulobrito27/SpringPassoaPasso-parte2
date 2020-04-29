package com.example.SpringPassoAPasso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPassoAPasso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
