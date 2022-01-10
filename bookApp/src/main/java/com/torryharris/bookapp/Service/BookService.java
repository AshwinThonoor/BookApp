package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.BookRepo;
import com.torryharris.bookapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;


    public List<Books> booksList(){
        return bookRepo.findAll();
    }
    public String addBook(Books books, Model model){
        bookRepo.save(books);
        List<Books>booksList=bookRepo.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }
    public String modifyBook(Books books, Model model){
        if(bookRepo.existsById(books.getBookCode())) {
            bookRepo.save(books);
            List<Books>booksList=bookRepo.findAll();
            model.addAttribute("ListBooks",booksList);
            return "AdminTable";
        }
        return "AdminTable";
    }
    public String deleteBook(Books books, Model model){
        bookRepo.deleteById(books.getBookCode());
        List<Books>booksList=bookRepo.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }

    public String adminTableDetails(Model model){
        List<Books>booksList=bookRepo.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable.html";

    }

    public List<Books> findAllByAuthorStartingWith(String author){
        return bookRepo.findAllByAuthorStartingWith(author);
    }

    public List<Books> findAllByBookNameIsStartingWith(String bookName){
        return bookRepo.findAllByBookNameIsStartingWith(bookName);
    }

    public Books findByBookCode(int bookCode) {
        return bookRepo.findById(bookCode).get();
    }
}
