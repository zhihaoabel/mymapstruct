package com.abel.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String manufacturer;
    private Integer seatCount;
    private List<String> features;
    private String price;
    private String manufacturingDate;
}
