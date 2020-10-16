import lab2_functions.AdvancedLogFunctions;
import lab2_functions.BasicFuncLn;
import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

class AdvancedLogFunctionsTest {

    private static final Double ln2_actual_value = 0.69314718;

    @Nested
    class AdvancedLogFunctionsUnitTest {

        @ParameterizedTest
        @CsvFileSource(resources = "/log2_adv_func_test.csv", numLinesToSkip = 1)
        void testLog2AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            BasicFuncLn mockLn = Mockito.mock(BasicFuncLn.class);

            Mockito.when(mockLn.ln(Mockito.eq(x), Mockito.anyDouble())).thenReturn(lnX);
            Mockito.when(mockLn.ln(Mockito.eq(2.0), Mockito.anyDouble())).thenReturn(ln2_actual_value);

            AdvancedLogFunctions log2Test = new AdvancedLogFunctions(mockLn);

            Double actual = log2Test.log_2(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

    }

    @Nested
    class AdvancedLogFunctionsIntegrationTest {

        @ParameterizedTest
        @CsvFileSource(resources = "/log2_adv_func_test.csv", numLinesToSkip = 1)
        void testLog2AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            BasicFuncLn basicLn = new BasicFuncLn();
            AdvancedLogFunctions log2Test = new AdvancedLogFunctions(basicLn);

            Double actual = log2Test.log_2(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

    }

}
