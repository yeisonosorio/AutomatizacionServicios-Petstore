package com.inditex.utils;

public enum ReqresResources {
    REQRES_BASE_URL("https://petstore.swagger.io/"),

    RESOURCES("v2/user/"),
    RESOURCES_MASCOTAS("v2/pet/findByStatus?status=");

    private final String value;

    ReqresResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
