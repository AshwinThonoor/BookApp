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
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookService bookService;
    @Autowired
    BookController bookController;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;

    public List<Cart> cartList(){
        return cartRepository.findAll();
    }

    public String addToCart(int bookCode, Model model, Cart cart){
        Books book=bookService.findByBookCode(bookCode);
        cart.setBookCode(book.getBookCode());
        cart.setBookName(book.getBookName());
        cart.setAuthor(book.getAuthor());
        cart.setPrice(book.getPrice());
        cart.setSection(book.getSection());
        cart.setAvailableBooks(book.getAvailableBooks());
        cart.setTotalNumberOfBooks(3);

        User user= userRepo.findAllByUserName(userService.username);
        cart.setUser(user);
        cartRepository.save(cart);

        return bookController.UserBooksTable(model);
    }
}
