package lab2_functions;

import static lab2_functions.BasicFunctions.*;

public class AdvancedFunctions {

    // trigonometry

    public static Double cos(Double x, Double precision) {
        if (x < -1 || x > 1) return Double.NaN;
        return sin(x + Math.PI/2, precision);
    }

    public static Double tan(Double x, Double precision) {
        if (cos(x, precision) == 0) return Double.NaN;
        return sin(x, precision) / cos(x, precision);
    }

    public static Double cot(Double x, Double precision) {
        return cos(x, precision) / sin(x, precision);
    }

    public static Double sec(Double x, Double precision) {
        return 1.0 / cos(x, precision);
    }

    // logarithm

    public static Double log_2(Double x, Double precision) {
        return ln(x, precision) / ln(2.0, precision);
    }

    public static Double log_3(Double x, Double precision) {
        return ln(x, precision) / ln(3.0, precision);
    }

    public static Double log_5(Double x, Double precision) {
        return ln(x, precision) / ln(5.0, precision);
    }

}