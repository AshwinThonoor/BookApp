package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
