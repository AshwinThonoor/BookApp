package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookService bookService;

    public String userLogin(Model model,User user,HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user1=userRepo.findAllByUserName(username);
        System.out.println(user1);
       // System.out.println(user1.getUserName());
        //System.out.println(username+password+user1.getUserName()+user1.getPassword());
        if(username.equals("admin") && password.equals("admin")){

            return bookService.adminTableDetails(model);
        }
        else if(username.equals(user1.getUserName()) && password.equals(user1.getPassword())){
            System.out.println(user1.getUserName()+user1.getPassword());
            return "outlook.html";
        }
        else {

            return "LoginPage.html";
        }
    }
    public String userAdd(User user){
        userRepo.save(user);
        System.out.println(user);
        return "LoginPage.html";
    }
}
