package com.example.bawarchirestaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Restaurant extends RestaurantAuth{
    private String name;

    private String contact;

    private int FoodCourtId;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishList;

    @OneToMany(mappedBy = "restaurant")
    private List<Ordered> orderedList;

    public Restaurant() {
    }

    public Restaurant(String name, String contact, int foodCourtId, List<Dish> dishList, List<Ordered> orderedList) {
        this.name = name;
        this.contact = contact;
        FoodCourtId = foodCourtId;
        this.dishList = dishList;
        this.orderedList = orderedList;
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

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Ordered> getOrderList() {
        return orderedList;
    }

    public void setOrderList(List<Ordered> orderedList) {
        this.orderedList = orderedList;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", FoodCourtId=" + FoodCourtId +
                ", dishList=" + dishList +
                ", orderList=" + orderedList +
                '}';
    }
}
