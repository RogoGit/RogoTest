import lab2_functions.BasicFunctions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BasicFunctionsTest {

    private static final String doubleNumFormat = "#.####";
    private static DecimalFormat formatter;

    @BeforeAll
    static void createNumberFormatter() {

        formatter = new DecimalFormat(doubleNumFormat);
        formatter.setRoundingMode(RoundingMode.CEILING);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ln_basic_func_test.csv", numLinesToSkip = 1)
    void testLnBasicFunction(Double x, Double precision, Double expected, String msg) {

        String expectedValue = formatter.format(expected);
        String actualValue = formatter.format(BasicFunctions.ln(x, precision));

        Assert.assertEquals("" + msg, expectedValue, actualValue);

    }

}
