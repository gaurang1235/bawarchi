package com.example.bawarchirestaurant.Security.Auth;


import com.example.bawarchirestaurant.Exception.ForbiddenException;
import com.example.bawarchirestaurant.Exception.ResourceNotFoundException;
import com.example.bawarchirestaurant.Repository.AuthRepository;
import com.example.bawarchirestaurant.Security.Configuration.JwtService;
import com.example.bawarchirestaurant.model.Auth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthRepository authRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AuthRepository authRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authRepository = authRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponse authenticate(Auth request) {
        try{
            System.out.println(request.getUsername());
            System.out.println(request.getPassword());
            System.out.println(request.getRole());
            System.out.println(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch(Exception exception){
            throw new ForbiddenException("Invalid Credentials. Please try again with valid credentials");
        }

        Auth user = authRepository.findByUsername(request.getUsername())
                .orElseThrow();

        if(user.getRole() != request.getRole()){
            throw new ResourceNotFoundException("Invalid Role. Please try again with valid credentials");
        }

        var jwtToken = jwtService.createToken(user);

        return new JwtResponse(jwtToken, user.getUsername());
    }

}
