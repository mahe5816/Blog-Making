package com.example.log.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface blo extends JpaRepository<bloo, Integer>{
	List<bloo> findByIdd(int idd);

}
