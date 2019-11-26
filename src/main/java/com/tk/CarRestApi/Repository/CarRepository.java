package com.tk.CarRestApi.Repository;


import com.tk.CarRestApi.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, String> {

    Car findByLicensePlate(String licensePlate);
}
