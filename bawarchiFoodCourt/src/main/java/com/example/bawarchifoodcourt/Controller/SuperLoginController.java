package com.example.bawarchifoodcourt.Controller;

import com.example.bawarchifoodcourt.Security.Auth.AuthenticationService;
import com.example.bawarchifoodcourt.Security.Auth.JwtResponse;
import com.example.bawarchifoodcourt.Service.SuperAdminService;
import com.example.bawarchifoodcourt.model.SuperAdmin;
import com.example.bawarchifoodcourt.model.SuperAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class SuperLoginController {

    AuthenticationService authenticationService;
    SuperAdminService superAdminService;

    Logger logger = LoggerFactory.getLogger(SuperLoginController.class);

    public SuperLoginController(AuthenticationService authenticationService, SuperAdminService superAdminService) {
        this.authenticationService = authenticationService;
        this.superAdminService = superAdminService;
    }

    @PostMapping("/")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody SuperAuth request){

        logger.info("Login API hit");

        JwtResponse response;
        try{
            response= authenticationService.authenticate(request);
        }catch(Exception exception){
            throw exception;
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addSuperAdmin")
    public ResponseEntity<SuperAdmin> addSuperAdmin(@RequestBody SuperAdmin superAdminIn){
        logger.info("Add superAdmin API hit");

        SuperAdmin superAdminOut = superAdminService.addSuperAdmin(superAdminIn);



        return ResponseEntity.of(Optional.of(superAdminOut));
    }



}
