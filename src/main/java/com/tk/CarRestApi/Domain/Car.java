package com.tk.CarRestApi.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Car")
@XmlRootElement
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "car_id", nullable = false, length = 64)
    private String carId;

    @Column(nullable = false)
    @Size(min = 1)
    @NotNull(message = "Model can't be null")
    private String model;

    @Column(nullable = false)
    @Size(min = 1)
    @NotNull(message = "License Plate can't Be Null")
    private String licensePlate;

    @Column(nullable = false)
    @Size(min = 1, max = 80)
    @NotNull(message = "Username can not be null!")
    private String seatCount;

    @Column(nullable = false)
    @NotNull(message = "Choose either true or False")
    private Boolean convertible;

    @Column(nullable = false)
    @NotNull(message = "Give the car a Rating on the Scale of 1 to 5")
    private int rating;

    @Column(nullable = false)
    @NotNull(message = "Engine Type can't be null")
    private EngineType engineType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "CarManufacturers",
            joinColumns = @JoinColumn(name = "manufacturer_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Manufacturer manufacturer;

    @OneToOne
    private JpaDriver driver;

    public Car() {
    }

    public Car(@NotNull @Size(min = 1, max = 64) String carId, @Size(min = 1) @NotNull(message = "Model can't be null") String model, @Size(min = 1) @NotNull(message = "License Plate can't Be Null") String licensePlate, @Size(min = 1, max = 80) @NotNull(message = "Username can not be null!") String seatCount, @NotNull(message = "Choose either true or False") Boolean convertible, @NotNull(message = "Give the car a Rating on the Scale of 1 to 5") int rating, @NotNull(message = "Engine Type can't be null") EngineType engineType, Manufacturer manufacturer, JpaDriver driver) {
        this.carId = carId;
        this.model = model;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.driver = driver;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public JpaDriver getDriver() {
        return driver;
    }

    public void setDriver(JpaDriver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", seatCount='" + seatCount + '\'' +
                ", convertible=" + convertible +
                ", rating=" + rating +
                ", engineType=" + engineType +
                ", manufacturer=" + manufacturer +
                ", driver=" + driver +
                '}';
    }
}
