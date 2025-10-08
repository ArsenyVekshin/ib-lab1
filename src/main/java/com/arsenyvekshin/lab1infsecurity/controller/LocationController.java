package com.arsenyvekshin.lab1infsecurity.controller;


import com.arsenyvekshin.lab1infsecurity.dto.LocationDto;
import com.arsenyvekshin.lab1infsecurity.entity.Location;
import com.arsenyvekshin.lab1infsecurity.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
@Tag(name = "Управление локациями", description = "Методы для управления коллекцией локаций")
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "Получить список всех локаций")
    @GetMapping()
    public List<Location> getAllLocation() {
        return locationService.getAllLocations();
    }

    @Operation(summary = "Создать локацию")
    @PostMapping()
    public void create(@RequestBody @Valid LocationDto request) {
        locationService.create(request);
    }
}
