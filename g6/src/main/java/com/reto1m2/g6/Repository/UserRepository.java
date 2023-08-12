package com.reto1m2.g6.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto1m2.g6.CrudRepository.UserCrudRepository;
import com.reto1m2.g6.Entities.User;

@Repository

public class UserRepository {
@Autowired
    private UserCrudRepository userCrudRepository;
    
    public User addUser(User user){
        return userCrudRepository.save(user);
    }

    public List <User> getAll(){
        return (List<User>)userCrudRepository.findAll();
    }

    public boolean getValidateEmail(String email){

        Optional <User> miUsuario = userCrudRepository.findByEmail(email);

        if (miUsuario.isEmpty())
            return false ;
        else
            return true;
    }

    public User getLogin(String email, String password){

        Optional <User> miUsuario = userCrudRepository.findByEmailAndPassword(email, password);
        User usuarioRespuesta= new User();  

        if (miUsuario.isEmpty()){
            usuarioRespuesta.setEmail(email);
            usuarioRespuesta.setPassword(password);
            usuarioRespuesta.setName("NO DEFINIDO");
            usuarioRespuesta.setId(null);
        }
        else{
            usuarioRespuesta = miUsuario.get();
        }
            return usuarioRespuesta;
    }

}




