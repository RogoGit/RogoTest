import lab2_functions.AdvancedTrigFunctions;
import lab2_functions.BasicFuncSin;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AdvancedTrigFunctionsTest {

    @Nested
    class AdvancedLogFunctionsUnitTest {

        @Mock
        private BasicFuncSin mockSin;

        @BeforeEach
        void initMocks() {
            MockitoAnnotations.initMocks(this);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/cos_adv_func_test.csv", numLinesToSkip = 1)
        void testCosAdvFunction(Double x, Double precision, Double expected, Double sinX, String msg) {

            Mockito.when(mockSin.sin(Mockito.eq(x + Math.PI/2),Mockito.anyDouble())).thenReturn(expected);

            AdvancedTrigFunctions cosTest = new AdvancedTrigFunctions(mockSin);

            Double actual = cosTest.cos(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/tan_adv_func_test.csv", numLinesToSkip = 1)
        void testTanAdvFunction(Double x, Double precision, Double expected, Double sinX, Double cosX, String msg) {

            Mockito.when(mockSin.sin(Mockito.eq(x), Mockito.anyDouble())).thenReturn(sinX);
            Mockito.when(mockSin.sin(Mockito.eq(x + Math.PI/2), Mockito.anyDouble())).thenReturn(cosX);

            AdvancedTrigFunctions tanTest = new AdvancedTrigFunctions(mockSin);

            Double actual = tanTest.tan(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/cot_adv_func_test.csv", numLinesToSkip = 1)
        void testCotAdvFunction(Double x, Double precision, Double expected, Double sinX, Double cosX, String msg) {

            Mockito.when(mockSin.sin(Mockito.eq(x), Mockito.anyDouble())).thenReturn(sinX);
            Mockito.when(mockSin.sin(Mockito.eq(x + Math.PI/2), Mockito.anyDouble())).thenReturn(cosX);

            AdvancedTrigFunctions cotTest = new AdvancedTrigFunctions(mockSin);

            Double actual = cotTest.cot(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/sec_adv_func_test.csv", numLinesToSkip = 1)
        void testSecAdvFunction(Double x, Double precision, Double expected, Double cosX, String msg) {

            Mockito.when(mockSin.sin(Mockito.eq(x + Math.PI/2), Mockito.anyDouble())).thenReturn(cosX);

            AdvancedTrigFunctions secTest = new AdvancedTrigFunctions(mockSin);

            Double actual = secTest.sec(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

    }

    @Nested
    class AdvancedTrigFunctionsIntegrationTest {

        BasicFuncSin basicFuncSin = new BasicFuncSin();

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/cos_adv_func_test.csv", numLinesToSkip = 1)
        void testCosAdvFunction(Double x, Double precision, Double expected, Double sinX, String msg) {

            AdvancedTrigFunctions cosTest = new AdvancedTrigFunctions(basicFuncSin);

            Double actual = cosTest.cos(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/tan_adv_func_test.csv", numLinesToSkip = 1)
        void testTanAdvFunction(Double x, Double precision, Double expected, Double sinX, Double cosX, String msg) {

            AdvancedTrigFunctions tanTest = new AdvancedTrigFunctions(basicFuncSin);

            Double actual = tanTest.tan(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/cot_adv_func_test.csv", numLinesToSkip = 1)
        void testCotAdvFunction(Double x, Double precision, Double expected, Double sinX, Double cosX, String msg) {

            AdvancedTrigFunctions cotTest = new AdvancedTrigFunctions(basicFuncSin);

            Double actual = cotTest.cot(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

        @ParameterizedTest
        @CsvFileSource(resources = "/trig_tests/sec_adv_func_test.csv", numLinesToSkip = 1)
        void testSecAdvFunction(Double x, Double precision, Double expected, Double cosX, String msg) {

            AdvancedTrigFunctions secTest = new AdvancedTrigFunctions(basicFuncSin);

            Double actual = secTest.sec(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);

        }

    }

}
