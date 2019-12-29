package com.scriptingproject.userservice.demo.controller;

import com.scriptingproject.userservice.demo.domain.Product;
import com.scriptingproject.userservice.demo.domain.ProductRepository;
import com.scriptingproject.userservice.demo.domain.User;
import com.scriptingproject.userservice.demo.service.ProductService;
import com.scriptingproject.userservice.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/user",produces = {"application/json"})
public class UserRestController {
    private UserService userService;
    private ProductService productService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserRestController(UserService userService, ProductService productService){
        this.userService=userService;
        this.productService=productService;
    }
    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> userList=userService.getUser();
        return userList;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts(){
       Product[] products=restTemplate.getForObject("http://localhost:8080/api/product/productlist",Product[].class);
       List<Product> product1=Arrays.asList(products);
       return product1;

    }

}
