package com.arsenyvekshin.lab1infsecurity.repository;

import com.arsenyvekshin.lab1infsecurity.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByName(String name);
}
