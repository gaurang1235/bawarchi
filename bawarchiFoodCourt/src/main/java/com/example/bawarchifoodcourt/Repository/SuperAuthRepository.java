package com.example.bawarchifoodcourt.Repository;

import com.example.bawarchifoodcourt.model.SuperAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAuthRepository extends JpaRepository<SuperAuth, Integer> {

    SuperAuth findByUsername(String username);

}
