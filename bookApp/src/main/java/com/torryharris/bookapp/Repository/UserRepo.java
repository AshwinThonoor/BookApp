package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    //public List<User> findAllByUserName(String username);
    public User findAllByUserName(String username);
}
