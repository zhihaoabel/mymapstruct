package com.abel.mapstruct.mapper;

import com.abel.mapstruct.dto.DivisionDTO;
import com.abel.mapstruct.dto.EmployeeDTO;
import com.abel.mapstruct.model.Division;
import com.abel.mapstruct.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    @Mapping(target = "employeeId", source = "entity.id")
    @Mapping(target = "employeeName", source = "entity.name")
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mapping(target = "id", source = "dto.employeeId")
    @Mapping(target = "name", source = "dto.employeeName")
    @Mapping(target = "division", source = "dto.division")
    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    DivisionDTO divisionToDivisionDTO(Division division);

    Division divisionDTOtoDivision(DivisionDTO divisionDTO);
}
