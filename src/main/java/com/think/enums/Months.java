package com.think.enums;

public enum Months {

    JANUARY("ene", 1),
    FEBRUARY("feb", 2),
    MARCH("mar", 3),
    APRIL("abr", 4),
    MAY("may", 5),
    JUNE("jun", 6),
    JULY("jul", 7),
    AUGUST("ago", 8),
    SEPTEMBER("sep", 9),
    OCTOBER("oct", 10),
    NOVEMBER("nov", 11),
    DECEMBER("dic", 12);

    private final String text;
    private final int index;

    Months(String text, int index){
        this.text = text;
        this.index = index;
    }

    public String getText(){
        return this.text;
    }
    public Integer getIndex(){
        return this.index;
    }

}
