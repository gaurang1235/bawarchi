package com.example.bawarchirestaurant.Service;


import com.example.bawarchirestaurant.Exception.ForbiddenException;
import com.example.bawarchirestaurant.Repository.AuthRepository;
import com.example.bawarchirestaurant.model.Auth;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public Auth loginCheck(String username, String password, String role) throws RuntimeException{
        Optional<Auth> superAuth = authRepository.findByUsername(username);

        if(superAuth.get().getRole().toString().equals(role) && superAuth.get().getPassword().equals(password)){
            return superAuth.get();
        }else {
            System.out.println("SuperAuth Login Failed");
            throw new RuntimeException();
        }
    }

    public void checkIfUserIdExists(String username){
//        validationHelper.usernamePasswordValidation(username);
        Optional<Auth> authorization = authRepository.findByUsername(username);

        if(authorization.isPresent()){
            throw new ForbiddenException("User already exists. Please try again with a different User id");
        }
    }

}
