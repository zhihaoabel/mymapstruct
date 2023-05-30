package com.abel.mapstruct.enums;

public enum OrderType {
    STANDARD("standard"),
    NORMAL("normal");

    private final String type;

    OrderType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public OrderType getOrderType(String type) {
        for (OrderType orderType : OrderType.values()) {
            if (orderType.getType().equals(type)) {
                return orderType;
            }
        }
        return null;
    }
}
