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
        return basicSinFunc.sin(x + Math.PI/2, precision);
    }

    public Double tan(Double x, Double precision) {
        if (cos(x, precision) == 0) return Double.NaN;
        return basicSinFunc.sin(x, precision / 100) / cos(x, precision / 100);
    }

    public Double cot(Double x, Double precision) {
        if (basicSinFunc.sin(x, precision) == 0) return Double.NaN;
        return cos(x, precision / 100) / basicSinFunc.sin(x, precision / 100);
    }

    public Double sec(Double x, Double precision) {
        if (cos(x, precision) == 0) return Double.NaN;
        return 1.0 / cos(x, precision);
    }

}
