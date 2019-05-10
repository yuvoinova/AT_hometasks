import java.util.Scanner;

public class EQSolver {

    public static void main(String[] args) {
        double discriminant, x1, x2, a, b, c;

        Scanner scanner = new Scanner(System.in);
        do {
            a = scan(scanner, "Введите первый коэфицент квадратного уравнения: число, отличное от 0", "a=");
        } while (a == 0);
        b = scan(scanner, "Введите второй коэфицент: любое число", "b=");
        c = scan(scanner, "Введите третий коэфицент: любое число", "c=");
        if (scanner != null) scanner.close();

        discriminant = b * b - 4 * a * c;
        System.out.println("D = " + doubleView(discriminant));
        System.out.print("Уравнение " + equationView(a, b, c));
        if (discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(" имеет 2 решения: x₁ = " + doubleView(x1) + "; x₂ = " + doubleView(x2));
        } else if (discriminant == 0) {
            x1 = (-b + 0) / (2 * a);
            System.out.println(" имеет 1 решение: x = " + doubleView(x1));
        } else {
            System.out.print(" не имеет действительных корней");
        }
    }


    private static String doubleView(double arg) {
        return String.format(arg + "").replaceAll("\\.0+$", "");
    }

    private static String equationView(double a, double b, double c) {
        String str;
        //Отображение коэфицента a:
        if (a == 1) str = "x²";
        else if (a == -1) str = "-x²";
        else str = doubleView(a) + "x²";
        //Отображение коэфицента b:
        if (b > 0) {
            if (b == 1) str = str + "+x";
            else str = str + "+" + doubleView(b) + "x";
        } else if (b < 0) {
            if (b == -1) str = str + "-x";
            else str = str + doubleView(b) + "x";
        }
        //Отображение коэфицента c:
        if (c > 0) {
            str = str + "+" + doubleView(c);
        } else if (c < 0) {
            str = str + doubleView(c);
        }
        return str + "=0";
    }

    private static double scan(Scanner scanner, String str1, String str2) {
        double num;
        scanner = new Scanner(System.in);
        System.out.println(str1);
        System.out.print(str2);
        while (!scanner.hasNextDouble()) {
            System.out.println(str1);
            System.out.print(str2);
            scanner = new Scanner(System.in);
        }
        num = scanner.nextDouble();

        return num;
    }
}
