package lab2_functions;

import static java.lang.Math.abs;

public class BasicFunctions {

    private static final double precision = 1e-8;


    // trigonometry

    public static Double sin(Double x) {

        if (x.isInfinite() || x.isNaN()) return Double.NaN;

        double result = 0;
        int seriesMemberNum = 1;
        double currentElementValue = x;

        while (abs(currentElementValue) >= precision) {

            result += currentElementValue;
            currentElementValue *= -x * x / (2 * seriesMemberNum * (2 * seriesMemberNum + 1));
            seriesMemberNum++;
        }

        return result;
    }

    // logarithm

    public static Double ln(Double x) {

        if (x.isNaN() || x < 0) return Double.NaN;

        if (x == 0) return Double.NEGATIVE_INFINITY;

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
