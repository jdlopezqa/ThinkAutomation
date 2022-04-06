package com.think.enums;

public enum SubMenuOption {

    EVENTS("Eventos");

    private final String text;

    SubMenuOption(String text){
        this.text = text;
    }

    public String asString(){
        return this.text;
    }
}
