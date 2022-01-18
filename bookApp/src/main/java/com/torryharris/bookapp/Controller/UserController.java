package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.UserRepo;
import com.torryharris.bookapp.Service.BookService;
import com.torryharris.bookapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String loginPage(){
        return "LoginPage";
    }

    @GetMapping("/registrationPage")

    public String registrationPage(){
        return "RegistrationPage";
    }

    @RequestMapping("/login")
    public String login(Model model, User user, Cart cart, HttpServletRequest request){
        return userService.userLogin(model,user,cart,request);
    }

    @RequestMapping("/register")
    public String addUser(User user){
        System.out.println("registration");
        System.out.println(user);
        return userService.userAdd(user);
    }

}
