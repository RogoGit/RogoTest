package com.testing_lab1;

import static java.lang.Math.*;

public class ArctgFunction {

    static Double arctgToPowerSeries(Double x) {

        if ( abs(x) <= 1) {

            double result = 0;
            int seriesMemberNum = 0;
            double currentElementValue = x;
            double precision = 1E-16;

            while (abs(currentElementValue) >= precision) {
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
