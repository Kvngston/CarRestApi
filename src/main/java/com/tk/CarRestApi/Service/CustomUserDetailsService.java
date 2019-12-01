/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tk.CarRestApi.Service;

import com.tk.CarRestApi.Domain.JpaDriver;
import com.tk.CarRestApi.Repository.JpaDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author HP
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JpaDriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JpaDriver driver = driverRepository.findByUsername(username);
        CustomUserDetails userDetails = null;

        if (driver != null) {
            userDetails = new CustomUserDetails();
            //System.out.println(user);
            userDetails.setDriver(driver);
        } else {
            throw new UsernameNotFoundException("user with username " + username + "does not exist");
        }

        return userDetails;
    }


}
