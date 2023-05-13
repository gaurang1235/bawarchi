package com.example.bawarchirestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private int dishId;

    private String name;

    private double price;

    private String category;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "dishList")
    @JsonIgnore
    private List<Ordered> orderedList;

    public Dish() {
    }

    public Dish(int dishId, String name, double price, String category, Restaurant restaurant, List<Ordered> orderedList) {
        this.dishId = dishId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.restaurant = restaurant;
        this.orderedList = orderedList;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Ordered> getOrderList() {
        return orderedList;
    }

    public void setOrderList(List<Ordered> orderedList) {
        this.orderedList = orderedList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", restaurant=" + restaurant +
                ", orderList=" + orderedList +
                '}';
    }
}
