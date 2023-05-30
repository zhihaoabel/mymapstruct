package com.abel.mapstruct.enums;

public enum ExternalOrderType {
    DEFAULT("default"),
    STANDARD("standard");

    private final String type;

    ExternalOrderType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public ExternalOrderType getExternalOrderType(String type) {
        for (ExternalOrderType externalOrderType : ExternalOrderType.values()) {
            if (externalOrderType.getType().equals(type)) {
                return externalOrderType;
            }
        }
        return null;
    }
}
