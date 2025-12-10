package com.intugratic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intugratic.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
