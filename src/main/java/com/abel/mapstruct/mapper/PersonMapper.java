package com.abel.mapstruct.mapper;

import com.abel.mapstruct.dto.PersonDTO;
import com.abel.mapstruct.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.DEFAULT, imports = UUID.class)
public interface PersonMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "fullName")
    PersonDTO personToPersonDTO(Person person);

    @Mapping( target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "name", target = "fullName")
    PersonDTO personWIthRandomId(Person person);
}
