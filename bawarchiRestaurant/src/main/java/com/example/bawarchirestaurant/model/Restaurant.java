package com.example.bawarchirestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Restaurant extends Auth {
    private String name;

    private String contact;

    private int foodCourtId;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishList;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<AllOrders> allOrdersList;

    public Restaurant() {
    }

    public Restaurant(int authId, String username, String password, Role role, String name, String contact, int foodCourtId, List<Dish> dishList, List<AllOrders> allOrdersList) {
        super(authId, username, password, role);
        this.name = name;
        this.contact = contact;
        this.foodCourtId = foodCourtId;
        this.dishList = dishList;
        this.allOrdersList = allOrdersList;
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
        return foodCourtId;
    }

    public void setFoodCourtId(int foodCourtId) {
        this.foodCourtId = foodCourtId;
    }

    public List<AllOrders> getAllOrdersList() {
        return allOrdersList;
    }

    public void setAllOrdersList(List<AllOrders> allOrdersList) {
        this.allOrdersList = allOrdersList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", foodCourtId=" + foodCourtId +
                ", dishList=" + dishList +
                ", allOrdersList=" + allOrdersList +
                '}';
    }
}
