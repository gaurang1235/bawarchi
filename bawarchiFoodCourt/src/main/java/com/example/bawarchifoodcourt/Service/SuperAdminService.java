package com.example.bawarchifoodcourt.Service;


import com.example.bawarchifoodcourt.Repository.SuperAdminRepository;
import com.example.bawarchifoodcourt.model.Role;
import com.example.bawarchifoodcourt.model.SuperAdmin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    private SuperAdminRepository superAdminRepository;

    private SuperAuthService superAuthService;

    PasswordEncoder passwordEncoder;

    public SuperAdminService(SuperAdminRepository superAdminRepository, SuperAuthService superAuthService, PasswordEncoder passwordEncoder) {
        this.superAdminRepository = superAdminRepository;
        this.superAuthService = superAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    public SuperAdmin addSuperAdmin(SuperAdmin superAdmin) throws RuntimeException {
        superAuthService.checkIfUserIdExists(superAdmin.getUsername());

        superAdmin.setPassword(passwordEncoder.encode(superAdmin.getPassword()));
        superAdmin.setRole(Role.ROLE_SUPER_ADMIN);
        return superAdminRepository.save(superAdmin);
    }

}
