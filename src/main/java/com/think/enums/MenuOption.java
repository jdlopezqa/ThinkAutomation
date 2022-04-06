package com.think.enums;

public enum MenuOption {
    
    EVENTS_DECISIONS("Eventos y Decisiones");
    
    private final String text;

    MenuOption(String text){
        this.text = text;
    }

    public String asString(){
        return this.text;
    }

}
