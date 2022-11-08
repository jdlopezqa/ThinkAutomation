package com.think.enums;

public enum SubMenuOption {

    EVENTS("Eventos"),
    VARIABLES("Variables"),
    MY_RESPONSABILITIES("Mis responsabilidades")
    ;

    private final String text;

    SubMenuOption(String text){
        this.text = text;
    }

    public String asString(){
        return this.text;
    }
}
