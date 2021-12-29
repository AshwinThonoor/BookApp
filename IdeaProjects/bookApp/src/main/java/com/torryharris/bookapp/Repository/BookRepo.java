package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,String> {
}
