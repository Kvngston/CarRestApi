package com.tk.CarRestApi;

import com.tk.CarRestApi.Domain.JpaDriver;
import com.tk.CarRestApi.Domain.Role;
import com.tk.CarRestApi.Repository.JpaDriverRepository;
import com.tk.CarRestApi.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;

@SpringBootApplication
public class CarRestApiApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    @Autowired
	private RoleRepository roleRepository;

    @Autowired
    private JpaDriverRepository driverRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarRestApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

        Calendar date = Calendar.getInstance();

        Role role = new Role();
        role.setRole("driver");
        roleRepository.save(role);

        JpaDriver driver = new JpaDriver();
        driver.setUsername("Tk");
        driver.setPassword(passwordEncoder.encode("12345"));
        driver.setRole(role);
        driver.setOnlineStatus("online");
        driver.setDateCreated(date.getTime());

        driverRepository.save(driver);



	}
}
