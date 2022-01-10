package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.BookRepo;
import com.torryharris.bookapp.Repository.UserRepo;
import com.torryharris.bookapp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    //CRUD operations

    @GetMapping("/addBooks")
    public String addBook(Books books, Model model) {
        return "AddBooks";
    }
    @PostMapping("/addBooksValues")
    public String addBooksValues(Books books, Model model) {
        return bookService.addBook(books,model);
    }

    @GetMapping("/modifyBook/{bookCode}")
    public String modifyBook(@PathVariable("bookCode") int bookCode, Books books, Model model) {
        books=bookService.findByBookCode(bookCode);
        model.addAttribute("modifyBook",books);
        return "EditAdminTable";
    }

    @GetMapping("/modifyBookValues")
    public String modify(Books books,Model model){
        return bookService.modifyBook(books,model);
    }

    @GetMapping("/deleteBook/{bookCode}")
    public String deleteBook(@PathVariable("bookCode") int bookCode, Books books, Model model) {
        return bookService.deleteBook(books,model);
    }

    @RequestMapping("/adminTableDetails")
    public String showAdminTable(Model model){
        List<Books>booksList=bookService.booksList();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }

    @GetMapping("/UserBooksTable")
    public String UserBooksTable(Model model){
        List<Books>booksList=bookService.booksList();
        model.addAttribute("ListBooks",booksList);
        return "UserBooksTable";
    }

    @RequestMapping("/filter")
    public String filter(HttpServletRequest request, Model model ){
        switch (request.getParameter("filter")) {
                case "author":
                    List<Books>booksListByAuthor= bookService.findAllByAuthorStartingWith(request.getParameter("word"));
                    model.addAttribute("booksListByAuthor",booksListByAuthor);
                    return "AdminTable.html";
                case "bookName":
                    List<Books>booksListByBookName=bookService.findAllByBookNameIsStartingWith(request.getParameter("word"));
                    model.addAttribute("booksListByBookName",booksListByBookName);
                    return "AdminTable.html";
            }
        return "AdminTable.html";
    }

}