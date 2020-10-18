import lab2_functions.AdvancedLogFunctions;
import lab2_functions.BasicFuncLn;
import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class AdvancedLogFunctionsTest {

    private static final Double ln2_actual_value = 0.69314718;
    private static final Double ln3_actual_value = 1.09861229;
    private static final Double ln5_actual_value = 1.60943791;

    @Nested
    class AdvancedLogFunctionsUnitTest {

        @Mock
        BasicFuncLn mockLn = Mockito.mock(BasicFuncLn.class);

        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log2_adv_func_test.csv", numLinesToSkip = 1)
        void testLog2AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            Mockito.when(mockLn.ln(Mockito.eq(x), Mockito.anyDouble())).thenReturn(lnX);
            Mockito.when(mockLn.ln(Mockito.eq(2.0), Mockito.anyDouble())).thenReturn(ln2_actual_value);

            AdvancedLogFunctions log2Test = new AdvancedLogFunctions(mockLn);

            Double actual = log2Test.log_2(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log3_adv_func_test.csv", numLinesToSkip = 1)
        void testLog3AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            Mockito.when(mockLn.ln(Mockito.eq(x), Mockito.anyDouble())).thenReturn(lnX);
            Mockito.when(mockLn.ln(Mockito.eq(3.0), Mockito.anyDouble())).thenReturn(ln3_actual_value);

            AdvancedLogFunctions log3Test = new AdvancedLogFunctions(mockLn);

            Double actual = log3Test.log_3(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log5_adv_func_test.csv", numLinesToSkip = 1)
        void testLog5AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            Mockito.when(mockLn.ln(Mockito.eq(x), Mockito.anyDouble())).thenReturn(lnX);
            Mockito.when(mockLn.ln(Mockito.eq(5.0), Mockito.anyDouble())).thenReturn(ln5_actual_value);

            AdvancedLogFunctions log5Test = new AdvancedLogFunctions(mockLn);

            Double actual = log5Test.log_5(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

    }

    @Nested
    class AdvancedLogFunctionsIntegrationTest {

        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log2_adv_func_test.csv", numLinesToSkip = 1)
        void testLog2AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            BasicFuncLn basicLn = new BasicFuncLn();
            AdvancedLogFunctions log2Test = new AdvancedLogFunctions(basicLn);

            Double actual = log2Test.log_2(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log3_adv_func_test.csv", numLinesToSkip = 1)
        void testLog3AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            BasicFuncLn basicLn = new BasicFuncLn();
            AdvancedLogFunctions log3Test = new AdvancedLogFunctions(basicLn);

            Double actual = log3Test.log_3(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }


        @ParameterizedTest
        @CsvFileSource(resources = "/log_tests/log5_adv_func_test.csv", numLinesToSkip = 1)
        void testLog5AdvFunction(Double x, Double precision, Double expected, Double lnX, String msg) {

            BasicFuncLn basicLn = new BasicFuncLn();
            AdvancedLogFunctions log5Test = new AdvancedLogFunctions(basicLn);

            Double actual = log5Test.log_5(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

    }

}
