package com.example.bawarchirestaurant.Service;


import com.example.bawarchirestaurant.Repository.RestaurantAuthRepository;
import com.example.bawarchirestaurant.model.Auth;
import org.springframework.stereotype.Service;

@Service
public class RestaurantAuthService {

    private RestaurantAuthRepository restaurantAuthRepository;

    public RestaurantAuthService(RestaurantAuthRepository restaurantAuthRepository){
        this.restaurantAuthRepository = restaurantAuthRepository;
    }

//    public RestaurantAuth loginCheck(String username, String password, String role) throws RuntimeException{
//        RestaurantAuth restaurantAuth = restaurantAuthRepository.findByUsername(username);
//
//        if(restaurantAuth.getRole().equals(role) && restaurantAuth.getPassword().equals(password)){
//            return restaurantAuth;
//        }else {
//            System.out.println("Restaurant Login Failed");
//            throw new RuntimeException();
//        }
//    }

    public Auth loginCheck(String username, String password, String role) throws RuntimeException{
        Auth auth = restaurantAuthRepository.findByUsername(username);

        if(auth.getRole().equals(role) && auth.getPassword().equals(password)){
            return auth;
        }else {
            System.out.println("Restaurant Login Failed");
            throw new RuntimeException();
        }
    }

}
