package com.tk.CarRestApi.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name = "Manufacturer")
@XmlRootElement
public class Manufacturer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Size(min = 1)
    @Column(name = "manufacturer_id", nullable = false)
    private String manufacturerId;

    private String name;

    @OneToMany()
    private List<Car> car;

    public Manufacturer() {
    }

    public Manufacturer(@NotNull @Size(min = 1) String manufacturerId, String name, List<Car> car) {
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.car = car;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId='" + manufacturerId + '\'' +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
