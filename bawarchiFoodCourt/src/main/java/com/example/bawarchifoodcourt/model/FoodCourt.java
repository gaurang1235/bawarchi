package com.example.bawarchifoodcourt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class FoodCourt extends SuperAuth{
    private String name;

    private String address;

    public FoodCourt() {
    }

    public FoodCourt(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FoodCourt{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
