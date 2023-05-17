package com.example.bawarchirestaurant.Repository;

import com.example.bawarchirestaurant.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
