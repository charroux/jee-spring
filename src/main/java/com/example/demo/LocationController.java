package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public Car getCar(@PathVariable("plaque") String immat) throws CarNotFoundException {
        int i=0;
        while(i<cars.size() && cars.get(i).getPlaque().equals(immat)==false){
            i++;
        }
        if(i<cars.size()){
            return cars.get(i);
        } else {
            throw new CarNotFoundException();
        }
    }
    /**
     * http://localhost:8080/cars/11AABB
     * @param immat
     * @return
     */
    /*@GetMapping("/cars/{plaque}")
    public Car getCar(@PathVariable("plaque") String immat) throws CarNotFoundException {
        try{
            Optional<Car> car = cars.stream().filter(c -> c.plaque.equals(immat)).findFirst();
            System.out.println(car);
            return car.get();
        } catch (NoSuchElementException e) {
            throw new CarNotFoundException();
        }
    }*/

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