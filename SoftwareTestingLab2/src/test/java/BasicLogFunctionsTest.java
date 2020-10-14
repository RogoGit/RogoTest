import lab2_functions.BasicFunctions;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class BasicLogFunctionsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/ln_basic_func_test.csv", numLinesToSkip = 1)
    void testLnBasicFunction(Double x, Double precision, Double expected, String msg) {

        BasicFunctions ln = new BasicFunctions();
        Double actual = ln.ln(x, precision);

        Assert.assertEquals("Description: " + msg, expected, actual, precision);

    }

}
