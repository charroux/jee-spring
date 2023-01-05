package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CarRepository carRepository) {
		return (args) -> {
			Car car = new Car("Ferrari", 1000, "AA11BB");
			carRepository.save(car);

			Iterator<Car> cars = carRepository.findAll().iterator();
			while(cars.hasNext()){
				Car c = cars.next();
				System.out.println(c.getMarque() + " " + c.getPrix() + " " + c.getPlaque());
			}
		};
	}

}
