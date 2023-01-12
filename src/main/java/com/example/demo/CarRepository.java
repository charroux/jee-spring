package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

    public Car findByMarque(String marque);

}
