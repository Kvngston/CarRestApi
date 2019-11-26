package com.tk.CarRestApi.Controllers;

import com.tk.CarRestApi.Domain.Car;
import com.tk.CarRestApi.Domain.JpaDriver;
import com.tk.CarRestApi.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Car/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    //Get the List of Cars in the Database
    @GetMapping("/carList")
    public List<Car> getAllCars(){

        return carRepository.findAll();

    }

    //Add a Car to the List
    @PostMapping("/addCar")
    public Car addCar(@Valid @RequestBody Car car){

        return carRepository.save(car);
    }


    //find by license Plate Number
    @GetMapping("/car/{licensePlate}")
    public Car findByLicensePlate(@PathVariable(value = "licensePlate") String licensePlate){

        return carRepository.findByLicensePlate(licensePlate);
    }

    //get a Car's  Rating
    @GetMapping("/getCarRating/{id}")
    public int getCarRating(@PathVariable(value = "id") String carId){

        Optional<Car> car = carRepository.findById(carId);

        return car.map(Car::getRating).orElse(0);
    }


    //Get a Car's Details and Information
    @GetMapping("/carDetails/{id}")
    public Car getCarDetails(@PathVariable(value = "id") String carId){

        Optional<Car> car = carRepository.findById(carId);
        return car.orElse(null);

    }

}
