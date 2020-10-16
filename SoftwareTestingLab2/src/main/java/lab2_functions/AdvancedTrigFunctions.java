package lab2_functions;

public class AdvancedTrigFunctions {

    private BasicFuncSin basicSinFunc;

    public AdvancedTrigFunctions(BasicFuncSin basicFuncSin) {
        this.basicSinFunc = basicFuncSin;
    }

    public BasicFuncSin getBasicSinFunc() {
        return basicSinFunc;
    }

    // trigonometry

    public Double cos(Double x, Double precision) {
        if (x < -1 || x > 1) return Double.NaN;
        return basicSinFunc.sin(x + Math.PI/2, precision);
    }

    public Double tan(Double x, Double precision) {
        if (cos(x, precision) == 0) return Double.NaN;
        return basicSinFunc.sin(x, precision) / cos(x, precision);
    }

    public Double cot(Double x, Double precision) {
        return cos(x, precision) / basicSinFunc.sin(x, precision);
    }

    public Double sec(Double x, Double precision) {
        return 1.0 / cos(x, precision);
    }

}
