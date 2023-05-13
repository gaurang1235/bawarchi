package com.example.bawarchifoodcourt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "authId")
public class SuperAdmin extends SuperAuth{
    public SuperAdmin() {
    }

    public SuperAdmin(int authId, String username, String password, Role role) {
        super(authId, username, password, role);
    }

    @Override
    public String toString() {
        return "SuperAdmin{}";
    }
}
