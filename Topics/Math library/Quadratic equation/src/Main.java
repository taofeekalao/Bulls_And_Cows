import java.util.Scanner;

import static java.lang.Math.sqrt;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double x1;
        double x2;

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double sqrt = sqrt(Math.pow(b, 2) - 4 * a * c);
        x1 = (-1 * b + sqrt) / (2 * a);
        x2 = (-1 * b - sqrt) / (2 * a);
        System.out.print(Math.min(x1, x2) + " " + Math.max(x1, x2));
    }
}
