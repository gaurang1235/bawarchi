package com.example.bawarchifoodcourt.Repository;

import com.example.bawarchifoodcourt.model.SuperAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperAuthRepository extends JpaRepository<SuperAuth, Integer> {

//    SuperAuth findByUsername(String username);

    Optional<SuperAuth> findByUsername(String username);

}
