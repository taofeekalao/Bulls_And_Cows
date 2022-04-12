import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        /*
        char[] inputString = scanner.nextLine().toCharArray();

        for (char character : inputString) {
            System.out.print(character + "" + character);
        }
        */

        String anotherString = scanner.next();

        for (int i = 0; i < anotherString.length(); i++) {
            System.out.print(anotherString.charAt(i) + "" + anotherString.charAt(i));
        }
    }
}