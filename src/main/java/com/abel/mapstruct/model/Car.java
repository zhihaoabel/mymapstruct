package com.abel.mapstruct.model;

// generate a Car class like below record class

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String make;
    private Integer numberOfSeats;
    private List<String> features;
    private Double price;
    private Date manufacturingDate;
}
