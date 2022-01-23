package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Controller.BookController;
import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Model.User;
import com.torryharris.bookapp.Repository.CartRepository;
import com.torryharris.bookapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookServiceImplementation bookServiceImplementation;
    @Autowired
    BookController bookController;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserServiceImplementation userService;
    static private int total=0;

    public List<Cart> cartList(){
        return cartRepository.findAllByUser(userRepo.findAllByUserName(userService.username));
    }

    public String addToCart(int bookCode, Model model, Cart cart,int quantity){
        Books book= bookServiceImplementation.findByBookCode(bookCode);
        cart.setBookCode(book.getBookCode());
        cart.setBookName(book.getBookName());
        cart.setAuthor(book.getAuthor());
        cart.setPrice(book.getPrice());
        cart.setSection(book.getSection());
        cart.setAvailableBooks(book.getAvailableBooks());
        cart.setTotalNumberOfBooks(quantity);

        total+=quantity*book.getPrice();
        System.out.println(total+"cart service");

        User user= userRepo.findAllByUserName(userService.username);
        cart.setUser(user);
        cartRepository.save(cart);
        model.addAttribute("total",total);

        return bookController.ReloadUserBooksTable(model);
    }
//    public String emptyCart(){
//        User user= userRepo.findAllByUserName(userService.username);
//        cartRepository.deleteCartByUser(user);
//        return "payment";
//    }
}
