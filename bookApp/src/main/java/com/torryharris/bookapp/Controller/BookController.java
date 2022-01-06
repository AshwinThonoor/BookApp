package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.BookRepo;
import com.torryharris.bookapp.Repository.UserRepo;
import com.torryharris.bookapp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    BookService bookService;

    //CRUD operations
    @PostMapping("/detailsPage")
    public String add(Books books, HttpServletRequest request) {
        String value=request.getParameter("value");
        return bookService.addBook(books,value);
    }
    @RequestMapping("/adminTableDetails")
    public String showAdminTable(Model model){
        List<Books>booksList=bookService.booksList();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable.html";
    }
    @RequestMapping("/filter")
    public String filter(HttpServletRequest request, Model model ){
        switch (request.getParameter("filter")) {
                case "author":
                    List<Books>booksListByAuthor= bookService.findAllByAuthorStartingWith(request.getParameter("word"));
                    model.addAttribute("booksListByAuthor",booksListByAuthor);
                    break;
                case "bookName":
                    List<Books>booksListByBookName=bookService.findAllByBookNameIsStartingWith(request.getParameter("word"));
                    model.addAttribute("booksListByBookName",booksListByBookName);
                    break;
            }
        return "AdminTable.html";
    }

}