import lab2_functions.BasicFuncSin;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class BasicTrigFunctionsTest {

    private BasicFuncSin sinTest = new BasicFuncSin();

    @ParameterizedTest
    @CsvFileSource(resources = "/trig_tests/sin_basic_func_test.csv", numLinesToSkip = 1)
    void testLnBasicFunction(Double x, Double precision, Double expected, String msg) {

        Double actual = sinTest.sin(x, precision);

        Assert.assertEquals("Description: " + msg, expected, actual, precision);

    }

}
