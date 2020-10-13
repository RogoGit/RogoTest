package lab2_functions;

import static lab2_functions.BasicFunctions.*;

public class AdvancedFunctions {

    // trigonometry

    public static Double cos(Double x) {
        if (x < -1 || x > 1) return Double.NaN;
        return sin(x + Math.PI/2);
    }

    public static Double tan(Double x) {
        if (cos(x) == 0) return Double.NaN;
        return sin(x) / cos(x);
    }

    public static Double cot(Double x) {
        return cos(x) / sin(x);
    }

    public static Double sec(Double x) {
        return 1.0 / cos(x);
    }

    // logarithm

    public static Double log_2(Double x) {
        return ln(x) / ln(2.0);
    }

    public static Double log_3(Double x) {
        return ln(x) / ln(3.0);
    }

    public static Double log_5(Double x) {
        return ln(x) / ln(5.0);
    }

}
