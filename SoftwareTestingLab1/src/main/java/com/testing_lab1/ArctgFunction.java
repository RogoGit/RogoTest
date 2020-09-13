package com.testing_lab1;

import static java.lang.Math.*;

public class ArctgFunction {

    public static final double precision = 1e-16;

    public static Double arctgToPowerSeries(Double x) {

        if ( abs(x) <= 1) {

            double result = 0;
            int seriesMemberNum = 0;
            int limit = 100000000;
            double currentElementValue = x;

            while (abs(currentElementValue) >= precision && (seriesMemberNum < limit)) {
                currentElementValue = (pow(-1, seriesMemberNum) * pow(x,(2*seriesMemberNum+1))) / (2*seriesMemberNum+1);
                result += currentElementValue;
                seriesMemberNum++;
            }

            return result;

        } else {
            return null;
        }

    }

}
