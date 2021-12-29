package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.BookRepo;
import com.torryharris.bookapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;
    @RequestMapping("login")
    public String login(User user, HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user1=userRepo.findById(username).orElse(new User());
        //System.out.println(username+password+user1.getUserName()+user1.getPassword());
        if(username.equals("admin") && password.equals("admin")){
            return "AdminPage.jsp";
        }
        else if(username.equals(user1.getUserName()) && password.equals(user1.getPassword())){
            //System.out.println(username.compareTo(user1.getUserName()));
            return "outlook.html";
        }
        else {

            return "LoginPage.jsp";
        }
    }
    @RequestMapping("Register")
    public String addUser(User user){
        userRepo.save(user);
        return "LoginPage.jsp";
    }

    //CRUD operations
    @RequestMapping("detailsPage")
    public String add(Books books, HttpServletRequest request) {
        switch (request.getParameter("value")) {
            case "Add":
                bookRepo.save(books);
                //System.out.println("Added successfully");
                break;
            case "Modify":
                bookRepo.save(books);
                //System.out.println("Modified successfully");
                break;
            case "Delete":
                bookRepo.delete(books);
                //System.out.println("Deleted successfully");
                break;
        }
        return "DetailsPage.jsp";
    }

}
