package com.think.enums;

public enum Messages {
    
    SUCCESSFULLY_SAVED("\u00A1Operaci\u00F3n Exitosa!"),
    ERROR_SAVED("¡Hay un Error!");
    
    private final String text;

    Messages(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

}