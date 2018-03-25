package com.inventorywebservice.inventorymanager.util;


public class CustomBodyType {

    private String errorMessage;

    public CustomBodyType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
