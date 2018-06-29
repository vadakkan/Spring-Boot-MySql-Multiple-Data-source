package com.nitheesh.mvc.primary.repository;

import com.nitheesh.mvc.primary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
