package com.reto1m2.g6.CrudRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto1m2.g6.Entities.User;

public interface UserCrudRepository extends CrudRepository<User, Long>{
    
    @Query(value = "SELECT * FROM users WHERE user_email = ?",nativeQuery=true)
    public Optional<User> findByEmail(String email);

    @Query(value="SELECT * FROM users WHERE user_email = ? and user_password = ?",nativeQuery=true)
    public Optional<User> findByEmailAndPassword(String email, String password);

}
