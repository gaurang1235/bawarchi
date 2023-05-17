package com.example.bawarchirestaurant.Service;

import com.example.bawarchirestaurant.Repository.CustomerRepository;
import com.example.bawarchirestaurant.model.Customer;
import com.example.bawarchirestaurant.model.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private AuthService superAuthService;

    private PasswordEncoder passwordEncoder;

    private CustomerRepository customerRepository;

    public CustomerService(AuthService superAuthService, PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.superAuthService = superAuthService;
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) throws RuntimeException {
        superAuthService.checkIfUserIdExists(customer.getUsername());

        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }
}
