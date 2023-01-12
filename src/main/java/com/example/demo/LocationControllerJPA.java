package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationControllerJPA {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/jpa/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

    /**
     * http://localhost:8080/cars/11AABB
     * @param immat
     * @return
     */
    @GetMapping("/jpa/cars/{plaque}")
    public Car getCar(@PathVariable("plaque") String immat) throws CarNotFoundException {
        Car car = carRepository.findByPlaque(immat);
        if(car == null){
            throw new CarNotFoundException("Voiture non trouvée : " + immat);
        }
        return car;
    }


    /**
     * http://localhost:8080/cars?louer=true
     */
    @PutMapping("/jpa/cars/{plaque}")
    public Car louer(@RequestParam("louer") boolean rent,
                     @PathVariable("plaque") String immat,
                     @RequestBody Dates dates) throws CarNotFoundException {

        Car car = carRepository.findByPlaque(immat);
        if(car == null){
            throw new CarNotFoundException("Voiture non trouvée : " + immat);
        }
        car.setRent(rent);
        car.setDates(dates);
        return car;
    }

    /**
     * Transmettre des données dans la requête
     */
    @PostMapping("jpa//cars")
    public void creerVoiture(@RequestBody Car car){
        System.out.println(car);
        // A faire : ajouter une voiture
    }


}
