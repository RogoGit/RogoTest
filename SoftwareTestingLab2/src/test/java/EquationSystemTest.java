import lab2_functions.AdvancedLogFunctions;
import lab2_functions.AdvancedTrigFunctions;
import lab2_functions.EquationSystem;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EquationSystemTest {

    @Mock
    private AdvancedLogFunctions advLogFuncMock = new AdvancedLogFunctions();

    @Mock
    private AdvancedTrigFunctions advTrigFuncMock = new AdvancedTrigFunctions();

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void mockTrig(Double x, Double precision, Double sin, Double cos, Double tan, Double cot, Double sec) {
        Mockito.when(advTrigFuncMock.sin(x, precision)).thenReturn(sin);
        Mockito.when(advTrigFuncMock.cos(x, precision)).thenReturn(cos);
        Mockito.when(advTrigFuncMock.tan(x, precision)).thenReturn(tan);
        Mockito.when(advTrigFuncMock.cot(x, precision)).thenReturn(cot);
        Mockito.when(advTrigFuncMock.sec(x, precision)).thenReturn(sec);
    }

    private void mockLog(Double x, Double precision, Double ln, Double log2, Double log3, Double log5) {
        Mockito.when(advLogFuncMock.ln(x, precision)).thenReturn(ln);
        Mockito.when(advLogFuncMock.log_2(x, precision)).thenReturn(log2);
        Mockito.when(advLogFuncMock.log_3(x, precision)).thenReturn(log3);
        Mockito.when(advLogFuncMock.log_5(x, precision)).thenReturn(log5);
    }

    @Nested
    class EquationSystemUnitTest {


        @ParameterizedTest
        @CsvFileSource(resources = "/equation_system_test.csv", numLinesToSkip = 1)
        void testSystemUnit(Double x, Double precision, Double expected,
                            Double sin, Double cos, Double tan, Double cot, Double sec,
                            Double ln, Double log2, Double log3, Double log5, String msg) {

            mockLog(x, precision, ln, log2, log3, log5);
            mockTrig(x, precision, sin, cos, tan, cot, sec);

            EquationSystem system = new EquationSystem(advTrigFuncMock, advLogFuncMock);
            Double actual = system.computeFunction(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision);
        }

    }

    @Nested
    class EquationSystemIntegrationTest {

        @ParameterizedTest
        @CsvFileSource(resources = "/equation_system_test.csv", numLinesToSkip = 1)
        void testSystemFullIntegration(Double x, Double precision, Double expected,
                            Double sin, Double cos, Double tan, Double cot, Double sec,
                            Double ln, Double log2, Double log3, Double log5, String msg) {


            EquationSystem system = new EquationSystem();
            Double actual = system.computeFunction(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision*10);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/equation_system_test.csv", numLinesToSkip = 1)
        void testSystemLogIntegration(Double x, Double precision, Double expected,
                                   Double sin, Double cos, Double tan, Double cot, Double sec,
                                   Double ln, Double log2, Double log3, Double log5, String msg) {


            mockTrig(x, precision, sin, cos, tan, cot, sec);
            EquationSystem system = new EquationSystem(advTrigFuncMock, new AdvancedLogFunctions());

            Double actual = system.computeFunction(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision*10);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/equation_system_test.csv", numLinesToSkip = 1)
        void testSystemTrigIntegration(Double x, Double precision, Double expected,
                                       Double sin, Double cos, Double tan, Double cot, Double sec,
                                       Double ln, Double log2, Double log3, Double log5, String msg) {


            mockLog(x, precision, ln, log2, log3, log5);
            EquationSystem system = new EquationSystem(new AdvancedTrigFunctions(), advLogFuncMock);

            Double actual = system.computeFunction(x, precision);

            Assert.assertEquals("Description: " + msg, expected, actual, precision*10);
        }


    }

}
