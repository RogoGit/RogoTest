import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ArctgTest {

    private static final String doubleNumFormat = "#.######";
    private static DecimalFormat formatter;

    @BeforeClass
    public static void createNumberFormatter() {

        formatter = new DecimalFormat(doubleNumFormat);
        formatter.setRoundingMode(RoundingMode.CEILING);

    }

    @Test
    public void testOutOfBoundsLeft() {

        Double actualValue = ArctgFunction.arctgToPowerSeries(-2.0);
        Assert.assertNull("Из-за невозможности разложения в ряд функция должна возвращать null", actualValue);

    }

    @Test
    public void testOutOfBoundsRight() {

        Double actualValue = ArctgFunction.arctgToPowerSeries(2.0);
        Assert.assertNull("Из-за невозможности разложения в ряд функция должна возвращать null", actualValue);

    }

    @Test
    public void testLeftBorder() {

        String expectedValue = formatter.format(Math.atan(-1.0));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(-1.0));

        Assert.assertEquals("Левая граница посчитанна неверно", expectedValue, actualValue);

    }

    @Test
    public void testRightBorder() {

        String expectedValue = formatter.format(Math.atan(1.0));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(1.0));

        Assert.assertEquals("Правая граница посчитанна неверно", expectedValue, actualValue);

    }

    @Test
    public void testYAxisInterception() {

        String expectedValue = formatter.format(Math.atan(0.0));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(0.0));

        Assert.assertEquals("Результат при х=0 неверен", expectedValue, actualValue);

    }

    @Test
    public void testPositiveStraightLineIn() {

        String expectedValue = formatter.format(Math.atan(0.15));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(0.15));

        Assert.assertEquals("Результат в положительном сегменте отрезка при росте функции близком к линейному неверен", expectedValue, actualValue);

    }

    @Test
    public void testPositiveStraightLineBorder() {

        String expectedValue = formatter.format(Math.atan(0.3));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(0.3));

        Assert.assertEquals("Результат при изменении характера роста функции в положительном сегменте неверен", expectedValue, actualValue);

    }

    @Test
    public void testPositiveCurvyLineIn() {

        String expectedValue = formatter.format(Math.atan(0.7));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(0.7));

        Assert.assertEquals("Результат в положительном сегменте отрезка при нелинейном росте функции неверен", expectedValue, actualValue);

    }

    @Test
    public void testNegativeStraightLineIn() {

        String expectedValue = formatter.format(Math.atan(-0.15));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(-0.15));

        Assert.assertEquals("Результат в отрицательном сегменте отрезка при росте функции близком к линейному неверен", expectedValue, actualValue);

    }

    @Test
    public void testNegativeStraightLineBorder() {

        String expectedValue = formatter.format(Math.atan(-0.3));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(-0.3));

        Assert.assertEquals("Результат при изменении характера роста функции в отрицательном сегменте неверен", expectedValue, actualValue);

    }

    @Test
    public void testNegativeCurvyLineIn() {

        String expectedValue = formatter.format(Math.atan(-0.7));
        String actualValue = formatter.format(ArctgFunction.arctgToPowerSeries(-0.7));

        Assert.assertEquals("Результат в отрицательном сегменте отрезка при нелинейном росте функции неверен", expectedValue, actualValue);

    }

}
