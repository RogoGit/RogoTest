import lab2_functions.AdvancedLogFunctions;
import lab2_functions.AdvancedTrigFunctions;
import lab2_functions.EquationSystem;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    static void writeLogToCSV(Double precision, AdvancedLogFunctions advLogFunc,
                              String filePath, Double leftBound, Double rightBound, Double step) {
        try {

            FileWriter writer = new FileWriter(filePath);
            writer.write("x,ln,log2,log3,log5\n");
            double currX = leftBound;
            while (currX <= rightBound) {
                writer.append(
                        String.format("%s,%s,%s,%s,%s\n",
                        currX,
                        advLogFunc.ln(currX, precision),
                        advLogFunc.log_2(currX, precision),
                        advLogFunc.log_3(currX, precision),
                        advLogFunc.log_5(currX, precision)));

                currX += step;
            }

            writer.flush();
            writer.close();

            System.out.println("Log results written");

        } catch (IOException e) {

            System.out.println("Log: IOException - writing to csv failed");

        }
    }

    static void writeTrigToCSV(Double precision, AdvancedTrigFunctions advTrigFunc,
                               String filePath, Double leftBound, Double rightBound, Double step) {
        try {

            FileWriter writer = new FileWriter(filePath);
            writer.write("x,sin,cos,tan,cot,sec\n");
            double currX = leftBound;
            while (currX <= rightBound) {
                writer.append(
                        String.format("%s,%s,%s,%s,%s,%s\n",
                                currX,
                                advTrigFunc.sin(currX, precision),
                                advTrigFunc.cos(currX, precision),
                                advTrigFunc.tan(currX, precision),
                                advTrigFunc.cot(currX, precision),
                                advTrigFunc.sec(currX, precision)));

                currX += step;
            }

            writer.flush();
            writer.close();

            System.out.println("Trig results written");

        } catch (IOException e) {

            System.out.println("Trig: IOException - writing to csv failed");

        }
    }

    static void writeSystemToCSV(Double precision, EquationSystem system,
                              String filePath, Double leftBound, Double rightBound, Double step) {
        try {

            FileWriter writer = new FileWriter(filePath);
            writer.write("x,result\n");
            double currX = leftBound;
            while (currX <= rightBound) {
                writer.append(
                        String.format("%s,%s\n",
                                currX,
                                system.computeFunction(currX, precision)));

                currX += step;
            }

            writer.flush();
            writer.close();

            System.out.println("Eq system results written");

        } catch (IOException e) {

            System.out.println("Eq system: IOException - writing to csv failed");
            e.printStackTrace();

        }
    }



}

