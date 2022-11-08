package com.think.enums;

public enum Actors {

    ADMIN("Administrador")
    ;
    private final String name;

    Actors(String name) {
        this.name = name;
    }

    public String getActorName() {
        return name;
    }

}
