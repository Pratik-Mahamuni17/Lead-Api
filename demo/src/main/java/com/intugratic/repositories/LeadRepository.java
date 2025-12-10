package com.intugratic.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intugratic.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{
	@Query("SELECT DISTINCT l FROM Lead l LEFT JOIN FETCH l.addresses")
    List<Lead> findAllWithAddresses();

    @Query(value = "SELECT DISTINCT l FROM Lead l LEFT JOIN FETCH l.addresses",
           countQuery = "SELECT COUNT(l) FROM Lead l")
    Page<Lead> findAllWithAddresses(Pageable pageable);
    
    @Query(
            value = "SELECT DISTINCT l FROM Lead l LEFT JOIN FETCH l.addresses a WHERE " +
                    "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR LOWER(l.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR LOWER(l.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR l.phone LIKE CONCAT('%', :keyword, '%')",
            countQuery = "SELECT COUNT(l) FROM Lead l WHERE " +
                    "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR LOWER(l.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR LOWER(l.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                    "OR l.phone LIKE CONCAT('%', :keyword, '%')"
    )
    Page<Lead> searchWithPagination(@Param("keyword") String keyword, Pageable pageable);


}
