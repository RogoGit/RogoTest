package com.testing_lab1;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {

    public static final String doubleNumFormat = "#.######";

    public static void main(String[] args) {

        ///////////// task1 ///////////

        DecimalFormat formatter = new DecimalFormat(doubleNumFormat);
        formatter.setRoundingMode(RoundingMode.CEILING);

        System.out.println(formatter.format(ArctgFunction.arctgToPowerSeries(0.9)));
        System.out.println(formatter.format(Math.atan(0.9)));

    }

}
