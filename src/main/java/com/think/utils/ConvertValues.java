package com.think.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConvertValues {

    public static String formatString(String value) {
        String[] values = value.split("\\.");
        return values[0].replace(",","");
    }

    public static String formatString(float value) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern("#,##0.00");
        return df.format(value);
    }
}
