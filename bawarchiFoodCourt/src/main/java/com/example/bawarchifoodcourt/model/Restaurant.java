package com.example.bawarchifoodcourt.model;

public class Restaurant {

    private int restaurantAuthId;

    private String username;

    private String password;

    private String  role;

    private String name;

    private String contact;

    private int FoodCourtId;



    public Restaurant() {
    }

    public Restaurant(String username, String password, String role, String name, String contact, int foodCourtId, int restaurantAuthId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
        FoodCourtId = foodCourtId;
        this.restaurantAuthId = restaurantAuthId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getFoodCourtId() {
        return FoodCourtId;
    }

    public void setFoodCourtId(int foodCourtId) {
        FoodCourtId = foodCourtId;
    }
}
