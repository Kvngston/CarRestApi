/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tk.CarRestApi.Service;

import com.tk.CarRestApi.Domain.JpaDriver;
import com.tk.CarRestApi.Domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HP
 */
public class CustomUserDetails implements UserDetails {

    //You first get the user
    private JpaDriver driver;

    public JpaDriver getDriver() {
        return driver;
    }

    public void setDriver(JpaDriver driver) {
        this.driver = driver;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(driver.getRole());
        return userRoles.stream().map(
                role -> new SimpleGrantedAuthority("ROLE" + role)
        ).collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return driver.getPassword();
    }

    @Override
    public String getUsername() {
        return driver.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
