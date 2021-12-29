package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
