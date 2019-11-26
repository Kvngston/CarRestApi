/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tk.CarRestApi.Domain;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "driver")
@XmlRootElement
public class JpaDriver implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "driver_id", nullable = false, length = 64)
    private String driverId;

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
    private boolean deleted;

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


    public JpaDriver() {
    }

    public JpaDriver(@NotNull @Size(min = 1, max = 64) String driverId, @Size(min = 1, max = 25) @NotNull(message = "Username can not be null!") String username, @Size(min = 1, max = 255) @NotNull(message = "Password can not be null!") String password, @NotNull(message = "online_status can not be null!") @Size(min = 1, max = 10) String onlineStatus, boolean deleted, @NotNull Date dateCreated, Date dateModified) {
        this.driverId = driverId;
        this.username = username;
        this.password = password;
        this.onlineStatus = onlineStatus;
        this.deleted = deleted;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
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

    @Override
    public String toString() {
        return "JpaDriver{" +
                "driverId='" + driverId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", onlineStatus='" + onlineStatus + '\'' +
                ", deleted=" + deleted +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
