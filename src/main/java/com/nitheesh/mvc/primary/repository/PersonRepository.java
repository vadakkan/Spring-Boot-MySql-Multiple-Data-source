package com.nitheesh.mvc.primary.repository;

import com.nitheesh.mvc.primary.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
