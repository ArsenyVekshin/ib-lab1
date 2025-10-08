package com.arsenyvekshin.lab1infsecurity.controller;


import com.arsenyvekshin.lab1infsecurity.dto.LocationDto;
import com.arsenyvekshin.lab1infsecurity.entity.Location;
import com.arsenyvekshin.lab1infsecurity.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping()
    public List<Location> getAllLocation() {
        return locationService.getAllLocations();
    }

    @PostMapping()
    public void create(@RequestBody LocationDto request) {
        locationService.create(request);
    }
}
