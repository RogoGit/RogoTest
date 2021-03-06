import static java.lang.Math.*;

public class ArctgFunction {

    private static final double precision = 1e-7;

    public static Double arctgToPowerSeries(double x) {

        if ( abs(x) <= 1) {

            double result = 0;
            int seriesMemberNum = 0;
            double currentElementValue = x;

            while (abs(currentElementValue) >= precision) {
                currentElementValue = (pow(-1, seriesMemberNum) * pow(x,(2*seriesMemberNum+1))) / (2*seriesMemberNum+1);
                result += currentElementValue;
                seriesMemberNum++;
            }

            return result;

        } else {
            return null;
        }

    }

}
