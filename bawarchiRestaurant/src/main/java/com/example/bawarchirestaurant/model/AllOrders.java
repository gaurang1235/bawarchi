package com.example.bawarchirestaurant.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AllOrders {
    @Id
    @GeneratedValue
    private int orderId;

    private int totalPrice;

    private String timestamp;

    private boolean status;

    private int tableNumber;

    private int userId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany
    private List<Dish> dishList;

    public AllOrders() {
    }

    public AllOrders(int orderId, int totalPrice, String timestamp, boolean status, int tableNumber, int userId, Restaurant restaurant, List<Dish> dishList) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
        this.status = status;
        this.tableNumber = tableNumber;
        this.userId = userId;
        this.restaurant = restaurant;
        this.dishList = dishList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", totalPrice=" + totalPrice +
                ", timestamp='" + timestamp + '\'' +
                ", status=" + status +
                ", tableNumber=" + tableNumber +
                ", userId=" + userId +
                ", restaurant=" + restaurant +
                ", dishList=" + dishList +
                '}';
    }
}
