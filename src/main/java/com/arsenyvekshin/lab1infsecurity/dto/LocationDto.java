package com.arsenyvekshin.lab1infsecurity.dto;

import lombok.Data;

@Data
public class LocationDto {
    private Long id;
    private Float x;
    private Float y;
    private Float z;
    private String name;
    private String description;
}
