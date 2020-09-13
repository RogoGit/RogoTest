import com.testing_lab1.ArctgFunction;
import com.testing_lab1.Main;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ArctgTest {

    @BeforeClass
    public static void createNumberFormatter() {

        DecimalFormat formatter = new DecimalFormat(Main.doubleNumFormat);
        formatter.setRoundingMode(RoundingMode.CEILING);

    }

    @Test
    public void testOutOfBoundsLeft() {

        Double expectedValue = ArctgFunction.arctgToPowerSeries(-2.0);
        Assert.assertNull("Из-за невозможности разложения в ряд функция должна возвращать null", expectedValue);

    }

    @Test
    public void testOutOfBoundsRight() {

        Double expectedValue = ArctgFunction.arctgToPowerSeries(2.0);
        Assert.assertNull("Из-за невозможности разложения в ряд функция должна возвращать null", expectedValue);

    }

    @Test
    public void testLeftBorder() {

        Double actualValue = Math.atan(-1.0);
        Double expectedValue = ArctgFunction.arctgToPowerSeries(-1.0);

        Assert.assertEquals("Из-за невозможн", expectedValue, actualValue);

    }

}
