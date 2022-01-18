package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Books,Integer> {
    public List<Books> findAllByAuthor(String author);
    public List<Books> findAllByBookNameIsStartingWith(String bookName);


}
