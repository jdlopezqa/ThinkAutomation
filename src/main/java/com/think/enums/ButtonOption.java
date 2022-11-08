package com.think.enums;

public enum ButtonOption {
    CLOSE("Cerrar"),
    ENTER_VALUES("Ingresar valores"),
    ;

    private final String text;

    ButtonOption(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
