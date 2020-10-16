import lab2_functions.BasicFuncLn;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class BasicLogFunctionsTest {

    private BasicFuncLn lnTest = new BasicFuncLn();

    @ParameterizedTest
    @CsvFileSource(resources = "/ln_basic_func_test.csv", numLinesToSkip = 1)
    void testLnBasicFunction(Double x, Double precision, Double expected, String msg) {

        Double actual = lnTest.ln(x, precision);

        Assert.assertEquals("Description: " + msg, expected, actual, precision);

    }

}
