package lab2_functions;

public class Main {

    public static void main(String[] args) {

        System.out.println(Math.sin(1.9));
        System.out.println(BasicFunctions.sin(1.9));

        System.out.println(Math.log(-1));
        System.out.println(BasicFunctions.ln(-1.0));

        System.out.println(Math.cos(0.4));
        System.out.println(AdvancedFunctions.cos(0.4));

        System.out.println(Math.tan(0.4));
        System.out.println(AdvancedFunctions.tan(0.4));


        System.out.println(EquationSystem.computeFunction(-0.5));
        System.out.println(EquationSystem.computeFunction(0.0));
        System.out.println(EquationSystem.computeFunction(1.5));

    }

}
