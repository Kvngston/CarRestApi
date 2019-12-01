/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tk.CarRestApi.Domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "driver")
@XmlRootElement
public class JpaDriver implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "driver_id", nullable = false, length = 64)
    private Long driverId;

    @Column(nullable = false)
    @Size(min = 1, max = 25)
    @NotNull(message = "Username can not be null!")
    private String username;

    @Column(nullable = false)
    @Size(min = 1, max = 255)
    @NotNull(message = "Password can not be null!")
    private String password;

    @Column(nullable = false, name = "online_status")
    @NotNull(message = "online_status can not be null!")
    @Size(min = 1, max = 10)
    private String onlineStatus;

    @Column(nullable = false, name = "deleted")
    private boolean deleted = false;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @OneToOne
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "driver_role",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;

    public JpaDriver() {
    }

    public JpaDriver(@Size(min = 1, max = 25) @NotNull(message = "Username can not be null!") String username, @Size(min = 1, max = 255) @NotNull(message = "Password can not be null!") String password, @NotNull(message = "online_status can not be null!") @Size(min = 1, max = 10) String onlineStatus, boolean deleted, @NotNull Date dateCreated, Date dateModified, Car car, Role role) {
        this.username = username;
        this.password = password;
        this.onlineStatus = onlineStatus;
        this.deleted = deleted;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.car = car;
        this.role = role;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "JpaDriver{" +
                "driverId=" + driverId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", onlineStatus='" + onlineStatus + '\'' +
                ", deleted=" + deleted +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", car=" + car +
                ", role=" + role +
                '}';
    }
}
