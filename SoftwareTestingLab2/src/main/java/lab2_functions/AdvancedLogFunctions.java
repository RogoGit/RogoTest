package lab2_functions;

public class AdvancedLogFunctions {

    private BasicFuncLn basicLnFunc = new BasicFuncLn();

    public AdvancedLogFunctions(BasicFuncLn basicLnFunc) {
        this.basicLnFunc = basicLnFunc;
    }

    public AdvancedLogFunctions() {}

    private BasicFuncLn getBasicLnFunc() {
        return basicLnFunc;
    }

    // logarithm

    public Double ln(Double x, Double precision) {
        return this.getBasicLnFunc().ln(x, precision);
    }

    public Double log_2(Double x, Double precision) {
        return basicLnFunc.ln(x, precision / 100) / basicLnFunc.ln(2.0, precision / 100);
    }

    public Double log_3(Double x, Double precision) {
        return basicLnFunc.ln(x, precision / 100) / basicLnFunc.ln(3.0, precision / 100);
    }

    public Double log_5(Double x, Double precision) {
        return basicLnFunc.ln(x, precision / 100) / basicLnFunc.ln(5.0, precision / 100);
    }

}
