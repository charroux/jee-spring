package com.example.demo;

import org.springframework.web.bind.annotation.*;

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
    public List<Car> getCars(){
        return cars;
    }

    /**
     * http://localhost:8080/cars/11AABB
     * @param immat
     * @return
     */
    @GetMapping("/cars/{plaque}")
    public Car getCar(@PathVariable("plaque") String immat){
        System.out.println(immat);
        // A faire : rechercher la voiture
        return null;
    }

    /**
     * http://localhost:8080/cars?louer=true
     */
    @PutMapping("/cars")
    public Car louer(@RequestParam("louer") boolean rent){
        System.out.println(rent);
        // A faire : louer la voiture
        return null;
    }

    /**
     * Transmettre des données dans la requête
     */
    @PostMapping("/cars")
    public void creerVoiture(@RequestBody Car car){
        System.out.println(car);
        // A faire : ajouter une voiture
    }
}