package com.abel.mapstruct.mapper;

import com.abel.mapstruct.enums.ExternalOrderType;
import com.abel.mapstruct.enums.OrderType;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    @ValueMappings({
            @ValueMapping(source = "STANDARD", target = "DEFAULT"),
            @ValueMapping(source = "NORMAL", target = MappingConstants.NULL)
    })
    ExternalOrderType orderTypeToExternalOrderType(OrderType orderType);
}
