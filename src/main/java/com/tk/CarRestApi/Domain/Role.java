package com.tk.CarRestApi.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String role;

    @OneToMany(mappedBy = "role")
    private List<JpaDriver> drivers;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<JpaDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<JpaDriver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
