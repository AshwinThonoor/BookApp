package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Model.Cart;
import com.torryharris.bookapp.Service.BookService;
import com.torryharris.bookapp.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class FlowController {

    @Autowired
    CartService cartService;
    @Autowired
    BookService bookService;

    @GetMapping("/cart")
    public String cart(Model model){

        //wrong change it into cart repo
        List<Cart> cartList=cartService.cartList();
        model.addAttribute("ListCart",cartList);
        return "Cart";
    }

    @RequestMapping("/shopping/{bookCode}")
    public String shopping(@PathVariable("bookCode") int bookCode, Model model, Cart cart, @RequestParam("Quantity") int quantity,@RequestParam("shopping") String shopping){
        if(Objects.equals(shopping, "addToCart")){
            //model.addAttribute("total",total);
            return cartService.addToCart(bookCode,model,cart,quantity);
        }
        else{
            cartService.addToCart(bookCode,model,cart,quantity);
            //model.addAttribute("total",total);
            return "redirect:/cart";
        }
    }

//    @RequestMapping("/addToCart/{bookCode}")
//    public String addToCart(@PathVariable("bookCode") int bookCode, Model model, Cart cart, @RequestParam("Quantity") int quantity){
//        return cartService.addToCart(bookCode,model,cart,quantity);
//    }
//    @GetMapping("/buyNow/{bookCode}")
//    public String buyNow(@PathVariable("bookCode") int bookCode, Model model, Cart cart, @RequestParam("Quantity") int quantity){
//        System.out.println(quantity);
//        cartService.addToCart(bookCode,model,cart,quantity);
//        return "redirect:/cart";
//    }

//    @PostMapping("/quantity")
//    public String quantity(int bookCode, Model model, Cart cart){
//       // cartService.addToCart(bookCode,model,cart);
//        System.out.println("quantity");
//        return "Cart";
//
//    }
    @GetMapping("/payment")
    public String payment(){
        return "payment";
    }

    @GetMapping("/confirmation")
    public String confirmation(){
        return "confirm";
    }

}
