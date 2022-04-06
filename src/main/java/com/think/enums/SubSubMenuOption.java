package com.think.enums;

public enum  SubSubMenuOption {

    MANAGE("Gestionar");

    private final String text;

    SubSubMenuOption(String text){
        this.text = text;
    }

    public String asString(){
        return this.text;
    }
}
