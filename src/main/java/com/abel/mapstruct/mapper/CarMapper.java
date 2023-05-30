package com.abel.mapstruct.mapper;

import com.abel.mapstruct.dto.CarDTO;
import com.abel.mapstruct.model.Car;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @InheritInverseConfiguration(name = "carToCarDto")
    Car toCar(CarDTO carDTO);

    @Mapping(target = "manufacturer", source = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    @Mapping(target = "price", numberFormat = "$#.00")
    @Mapping(target = "features", source = "features")
    @Mapping(target = "manufacturingDate", dateFormat = "yyyy-MM-dd")
    CarDTO carToCarDto(Car car);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "manufacturer", source = "make")
    CarDTO ignoreProps(Car car);

    default CarDTO custom(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setManufacturer(car.getMake());
        carDTO.setManufacturingDate("2023-05-05");
        return carDTO;
    }
}
