package com.example.bawarchifoodcourt.Service;

import com.example.bawarchifoodcourt.Repository.SuperAuthRepository;
import com.example.bawarchifoodcourt.model.SuperAuth;
import org.springframework.stereotype.Service;

@Service
public class SuperAuthService {

    private SuperAuthRepository superAuthRepository;

    public SuperAuthService(SuperAuthRepository superAuthRepository){
        this.superAuthRepository = superAuthRepository;
    }

    public SuperAuth loginCheck(String username, String password, String role) throws RuntimeException{
        SuperAuth superAuth = superAuthRepository.findByUsername(username);

        if(superAuth.getRole().toString().equals(role) && superAuth.getPassword().equals(password)){
            return superAuth;
        }else {
            System.out.println("SuperAuth Login Failed");
            throw new RuntimeException();
        }
    }

}
