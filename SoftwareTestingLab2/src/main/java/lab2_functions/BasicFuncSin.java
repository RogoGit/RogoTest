package lab2_functions;

import static java.lang.Math.abs;

public class BasicFuncSin {

    // trigonometry

    public Double sin(Double x, Double precision) {

        if (x.isInfinite() || x.isNaN() || precision.isNaN() || precision.isInfinite()) return Double.NaN;

        if (abs(x) < precision) return 0.0;

        double result = 0;
        int seriesMemberNum = 1;
        double currentElementValue = x;

        while (abs(currentElementValue) >= precision) {

            result += currentElementValue;
            currentElementValue *= -x * x / (2 * seriesMemberNum * (2 * seriesMemberNum + 1));
            seriesMemberNum++;
        }

        if (abs(result) < precision) return 0.0;
        return result;
    }

}
