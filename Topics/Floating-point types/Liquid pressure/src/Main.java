import java.util.Scanner;

class Main {

    static final double GRAVITY = 9.8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double density = scanner.nextDouble();
        double height = scanner.nextDouble();

        System.out.println(density * height * GRAVITY);
    }
}