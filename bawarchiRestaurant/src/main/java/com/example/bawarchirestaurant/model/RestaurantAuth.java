package com.example.bawarchirestaurant.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RestaurantAuth {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private int restaurantAuthId;

    @Column(unique = true)
    private String username;

    private String password;

    private String  role;

    public RestaurantAuth() {
    }

    public RestaurantAuth(int restaurantAuthId, String username, String password, String role) {
        this.restaurantAuthId = restaurantAuthId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getRestaurantAuthId() {
        return restaurantAuthId;
    }

    public void setRestaurantAuthId(int restaurantAuthId) {
        this.restaurantAuthId = restaurantAuthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RestaurantAuth{" +
                "restaurantAuthId=" + restaurantAuthId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
