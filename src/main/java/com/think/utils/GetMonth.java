package com.think.utils;

import lombok.SneakyThrows;

import static com.think.enums.Months.*;

public class GetMonth {

    @SneakyThrows
    public static String fromNumber(int numberMonth) {

        switch (numberMonth){
            case 1:
                return JANUARY.getText();
            case 2:
                return FEBRUARY.getText();
            case 3:
                return MARCH.getText();
            case 4:
                return APRIL.getText();
            case 5:
                return MAY.getText();
            case 6:
                return JUNE.getText();
            case 7:
                return JULY.getText();
            case 8:
                return AUGUST.getText();
            case 9:
                return SEPTEMBER.getText();
            case 10:
                return OCTOBER.getText();
            case 11:
                return NOVEMBER.getText();
            case 12:
                return DECEMBER.getText();
            default:
                throw new Exception("Month with number " + numberMonth + " not exist");
        }
    }

    @SneakyThrows
    public static Integer fromNumber(String numberMonth) {

        switch (numberMonth){
            case "01":
                return JANUARY.getIndex();
            case "02":
                return FEBRUARY.getIndex();
            case "03":
                return MARCH.getIndex();
            case "04":
                return APRIL.getIndex();
            case "05":
                return MAY.getIndex();
            case "06":
                return JUNE.getIndex();
            case "07":
                return JULY.getIndex();
            case "08":
                return AUGUST.getIndex();
            case "09":
                return SEPTEMBER.getIndex();
            case "10":
                return OCTOBER.getIndex();
            case "11":
                return NOVEMBER.getIndex();
            case "12":
                return DECEMBER.getIndex();
            default:
                throw new Exception("Month with number " + numberMonth + " not exist");
        }
    }

}
