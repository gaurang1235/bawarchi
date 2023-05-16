package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Integer> {

//    SuperAuth findByUsername(String username);

    Optional<Auth> findByUsername(String username);

}
