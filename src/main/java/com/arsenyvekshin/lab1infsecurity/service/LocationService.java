package com.arsenyvekshin.lab1infsecurity.service;

import com.arsenyvekshin.lab1infsecurity.dto.LocationDto;
import com.arsenyvekshin.lab1infsecurity.entity.Location;
import com.arsenyvekshin.lab1infsecurity.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional(rollbackFor = Exception.class)
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(LocationDto location) {
        Location entity = Location.builder()
                .x(location.getX())
                .y(location.getY())
                .z(location.getZ())
                .name(location.getName())
                .description(location.getDescription())
                .build();
        save(entity);
    }

    @Transactional(readOnly = true)
    public Location getLocationByName(String name) {
        Location location = locationRepository.findByName(name);
        if (location == null) throw new EntityNotFoundException("Локация не найденв");
        return location;
    }

    @Transactional(readOnly = true)
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}