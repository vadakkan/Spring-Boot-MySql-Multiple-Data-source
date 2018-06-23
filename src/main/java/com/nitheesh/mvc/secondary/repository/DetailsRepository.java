package com.nitheesh.mvc.secondary.repository;

import com.nitheesh.mvc.secondary.domain.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
}
