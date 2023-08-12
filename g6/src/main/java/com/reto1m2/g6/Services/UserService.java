package com.reto1m2.g6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto1m2.g6.Entities.User;
import com.reto1m2.g6.Repository.UserRepository;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    public List <User> getAll(){
        return (List<User>) userRepository.getAll();
    }

    public User addUser(User user){
        return userRepository.addUser(user);
    }

    public User getLogin(String email, String password){
        return userRepository.getLogin(email, password);
    }

    public Boolean getValidateEmail(String email){
        return userRepository.getValidateEmail(email);
    }

}
