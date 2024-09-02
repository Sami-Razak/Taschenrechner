import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie eine Zahl ein:");
        double Zahl1 = scanner.nextDouble();

        System.out.println("Geben Sie einen Operanden ein:");
        String OP = scanner.next();

        double result;

        if (OP.equals("+") || OP.equals("-") || OP.equals("*") || OP.equals("/") || OP.equals("sqrt") || OP.equals("^2")) {

            if (OP.equals("sqrt")) {
                if (Zahl1 >= 0) {
                    result = Math.sqrt(Zahl1);
                    System.out.println("Das Ergebnis lautet:" + result);
                } else {
                    System.out.println("Ungültige Eingabe");
                }
            } else if (OP.equals("^2")) {
                result = Math.pow(Zahl1, 2);
                System.out.println("Das Ergebnis lautet:" + result);

            } else {
                System.out.println("Geben Sie eine Zahl ein:");
                double Zahl2 = scanner.nextDouble();

                switch (OP) {

                    case "+":
                        result = Zahl1 + Zahl2;
                        break;

                    case "-":
                        result = Zahl1 - Zahl2;
                        break;

                    case "*":
                        result = Zahl1 * Zahl2;
                        break;

                    case "/":
                        if (Zahl2 != 0) {
                            result = Zahl1 / Zahl2;
                        } else {
                            System.out.println("Keine Division durch Null möglich");

                            return;
                        }
                        break;
                    default:
                        System.out.println("Ungültiger Operand");


                        return;
                }
                System.out.println("Das Eregbnis lautet" + result);
            }

        }
    }
}