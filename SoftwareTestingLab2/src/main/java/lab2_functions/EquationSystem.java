package lab2_functions;

import static java.lang.Math.pow;

public class EquationSystem {

   private BasicFuncSin basicFuncSin = new BasicFuncSin();
   private BasicFuncLn basicFuncLn = new BasicFuncLn();
   private AdvancedTrigFunctions advTrigFunc = new AdvancedTrigFunctions(basicFuncSin);
   private AdvancedLogFunctions advLogFunc = new AdvancedLogFunctions(basicFuncLn);

   public Double trigFunction(Double x, Double precision) {
        return (((((pow(advTrigFunc.tan(x, precision),2)) + (advTrigFunc.tan(x,precision) + advTrigFunc.cos(x,precision)))
                - advTrigFunc.cot(x,precision)) * advTrigFunc.tan(x, precision)) * (advTrigFunc.sec(x, precision)
                + advTrigFunc.getBasicSinFunc().sin(x, precision)));
   }

   public Double logFunction(Double x, Double precision) {
        return (((((pow(advLogFunc.log_5(x, precision),2))
                * advLogFunc.getBasicLnFunc().ln(x,precision)) - advLogFunc.log_2(x,precision))
                * (advLogFunc.log_3(x, precision) + advLogFunc.getBasicLnFunc().ln(x, precision))) + (advLogFunc.log_2(x, precision)
                * ((advLogFunc.log_2(x,precision) * advLogFunc.log_2(x, precision)) * advLogFunc.log_2(x, precision))));
   }

   public Double computeFunction(Double x, Double precision) {
        if (x <= 0) return trigFunction(x, precision);
        return logFunction(x, precision);
   }

}
