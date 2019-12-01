package com.tk.CarRestApi.Controllers;

import com.tk.CarRestApi.Domain.Car;
import com.tk.CarRestApi.Domain.JpaDriver;
import com.tk.CarRestApi.Model.CarInUseException;
import com.tk.CarRestApi.Repository.CarRepository;
import com.tk.CarRestApi.Repository.JpaDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver/")
public class DriverController {

    @Autowired
    private JpaDriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @PutMapping("/selectCar{id}")
    public Car selectCar(Principal principal, @PathVariable(value = "id") String id) throws CarInUseException {

        JpaDriver driver = driverRepository.findByUsername(principal.getName());

        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()){
            if(car.get().getDriver() != null){

                //set the driver to the car
                car.ifPresent(driver::setCar);

                //set the car to the driver
                car.ifPresent(value -> value.setDriver(driver));

                //Update both repositories
                car.ifPresent(value -> carRepository.save(value));
                driverRepository.save(driver);


            }else
                throw new CarInUseException("This Car has been Assigned to Another Driver");
        }



        return car.orElse(null);
    }


    //Pass the driver ID as A Path variable or Parameter
    @PutMapping("/deSelectCar{id}")
    public void deSelectCar(Principal principal, @PathVariable(value = "id") Long driverId){

        //get the current Logged in Driver
        JpaDriver driver = driverRepository.findByUsername(principal.getName());
        Car car = driver.getCar();
        car.setDriver(null);
        driver.setCar(null);

        driverRepository.save(driver);
        carRepository.save(car);
    }

    @GetMapping("/loggedInDriver")
    public JpaDriver getDriver(Principal principal){

        return driverRepository.findByUsername(principal.getName());
    }

    @GetMapping("/driverList")
    public List<JpaDriver> getDriverList(){

        return (List<JpaDriver>) driverRepository.findAll();
    }


    //Searching for Driver by Car details

    @GetMapping("/{licensePlate}")
    public JpaDriver findByLicensePlate(@PathVariable(value = "licensePlate") String licensePlate){

        Car car = carRepository.findByLicensePlate(licensePlate);
        return car.getDriver();
    }

    @GetMapping("/searchDriver{username}")
    public JpaDriver findByUsername(@PathVariable(value = "username") String username){

        return driverRepository.findByUsername(username);
    }


    @GetMapping("/searchCar{rating}")
    public List<Car> findByCarRating(@PathVariable(value = "rating") int rating){

        return carRepository.findAllByRating(rating);

    }

    @GetMapping("/getOnlineDrivers")
    public List<JpaDriver> findAllDriversOnline(){

        return driverRepository.findAllByOnlineStatus("online");
    }
}
