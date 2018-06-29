package com.nitheesh.mvc.primary.repository;

import com.nitheesh.mvc.primary.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
