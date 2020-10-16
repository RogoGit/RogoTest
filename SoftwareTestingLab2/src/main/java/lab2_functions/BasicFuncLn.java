package lab2_functions;

import static java.lang.Math.abs;

public class BasicFuncLn {

    // logarithm

    public Double ln(Double x, Double precision) {

        if (x == 0) return Double.NaN;

        if (x.isNaN() || x < 0 || precision.isInfinite() || precision.isNaN()) return Double.NaN;

        if (x <= precision) return Double.NEGATIVE_INFINITY;

        if (x == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;

        if (x < 1) {

            double z = x-1;
            double result = z;
            int seriesMemberNum = 2;
            double currentElementValue = z;

            while (abs(currentElementValue) >= precision) {
                currentElementValue *= -z;
                result += currentElementValue / seriesMemberNum;
                seriesMemberNum++;
            }

            return result;

        } else {

            double z = x / (x - 1);
            double result = 0;
            int seriesMemberNum = 1;
            double currentElementValue = z;

            while (abs(currentElementValue) >= precision) {
                currentElementValue = 1 / (seriesMemberNum * Math.pow(z, seriesMemberNum));
                result += currentElementValue;
                seriesMemberNum++;
            }

            return result;

        }

    }

}
