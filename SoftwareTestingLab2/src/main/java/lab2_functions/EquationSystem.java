package lab2_functions;

import static java.lang.Math.pow;
import static lab2_functions.AdvancedFunctions.*;
import static lab2_functions.BasicFunctions.*;

public class EquationSystem {

    public static Double trigFunction(Double x) {
        return (((((pow(tan(x),2)) + (tan(x) + cos(x))) - cot(x)) * tan(x)) * (sec(x) + sin(x)));
    }

    public static Double logFunction(Double x) {
        return (((((pow(log_5(x),2)) * ln(x)) - log_2(x)) * (log_3(x) + ln(x))) + (log_2(x) * ((log_2(x) * log_2(x)) * log_2(x))));
    }

    public static Double computeFunction(Double x) {
        if (x <= 0) return trigFunction(x);
        return logFunction(x);
    }

}
