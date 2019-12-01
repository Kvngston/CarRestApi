package com.tk.CarRestApi.Repository;

import com.tk.CarRestApi.Domain.JpaDriver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaDriverRepository extends CrudRepository<JpaDriver, Long> {
    JpaDriver findByUsername(String username);
    List<JpaDriver> findAllByOnlineStatus(String status);
}
