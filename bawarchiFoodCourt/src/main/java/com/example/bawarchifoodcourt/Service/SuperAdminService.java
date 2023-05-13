package com.example.bawarchifoodcourt.Service;


import com.example.bawarchifoodcourt.Repository.SuperAdminRepository;
import com.example.bawarchifoodcourt.model.Role;
import com.example.bawarchifoodcourt.model.SuperAdmin;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    private SuperAdminRepository superAdminRepository;

    public SuperAdminService(SuperAdminRepository superAdminRepository){
        this.superAdminRepository = superAdminRepository;
    }

    public SuperAdmin addSuperAdmin(SuperAdmin superAdminIn) throws RuntimeException {

        SuperAdmin superAdminOut = new SuperAdmin();

        superAdminOut.setUsername(superAdminIn.getUsername());
        superAdminOut.setPassword(superAdminIn.getPassword());
        superAdminOut.setRole(Role.ROLE_SUPER_ADMIN);

        superAdminOut = superAdminRepository.save(superAdminOut);

        return superAdminOut;
    }


}
