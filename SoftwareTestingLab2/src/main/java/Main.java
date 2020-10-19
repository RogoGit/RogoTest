import lab2_functions.*;

import java.util.Scanner;

public class Main {

    private static final String logFilePath = "/home/dell/RogoTest/SoftwareTestingLab2/out/log_out.csv";
    private static final String trigFilePath = "/home/dell/RogoTest/SoftwareTestingLab2/out/trig_out.csv";
    private static final String systemFilePath = "/home/dell/RogoTest/SoftwareTestingLab2/out/sys_out.csv";

    public static void main(String[] args) {

        BasicFuncSin basicFuncSin = new BasicFuncSin();
        BasicFuncLn basicFuncLn = new BasicFuncLn();
        AdvancedTrigFunctions advancedTrigFunc = new AdvancedTrigFunctions(basicFuncSin);
        AdvancedLogFunctions advancedLogFunc = new AdvancedLogFunctions(basicFuncLn);
        EquationSystem system = new EquationSystem(advancedTrigFunc,advancedLogFunc);

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter precision:");
        Double precision = Double.parseDouble(reader.nextLine());

        System.out.println("Eq system - enter left bound: ");
        Double eqSysLeftBound = Double.parseDouble(reader.nextLine());
        System.out.println("Eq system - enter right bound: ");
        Double eqSysRightBound = Double.parseDouble(reader.nextLine());
        System.out.println("Eq system - enter step: ");
        Double eqSysStep = Double.parseDouble(reader.nextLine());

        CsvWriter.writeSystemToCSV(precision, system, systemFilePath, eqSysLeftBound, eqSysRightBound, eqSysStep);

        System.out.println("Logarithm - enter left bound: ");
        Double logLeftBound = Double.parseDouble(reader.nextLine());
        System.out.println("Logarithm - enter right bound: ");
        Double logRightBound = Double.parseDouble(reader.nextLine());
        System.out.println("Logarithm - enter step: ");
        Double logStep = Double.parseDouble(reader.nextLine());

        CsvWriter.writeLogToCSV(precision, advancedLogFunc, logFilePath, logLeftBound, logRightBound, logStep);

        System.out.println("Trigonometry - enter left bound: ");
        Double trigLeftBound = Double.parseDouble(reader.nextLine());
        System.out.println("Trigonometry - enter right bound: ");
        Double trigRightBound = Double.parseDouble(reader.nextLine());
        System.out.println("Trigonometry - enter step: ");
        Double trigStep = Double.parseDouble(reader.nextLine());

        CsvWriter.writeTrigToCSV(precision, advancedTrigFunc, trigFilePath, trigLeftBound, trigRightBound, trigStep);

    }

}
