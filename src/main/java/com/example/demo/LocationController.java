package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    ArrayList<Car> cars = new ArrayList<Car>();

    public LocationController(){
        Car car = new Car("Ferrari", 200, "AA11BB");
        cars.add(car);
    }

    @GetMapping("/cars")
    public List<Car> disBonjour(){
        return cars;
    }

    @GetMapping("/cars/{plaque}")
    public String getCar(@PathVariable("plaque") String immat){
        System.out.println(immat);
        return immat;
    }

}