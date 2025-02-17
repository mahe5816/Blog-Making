package com.example.log.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface user extends JpaRepository<entry, Integer> {
	Optional<entry> findByEmail(String email);
}
