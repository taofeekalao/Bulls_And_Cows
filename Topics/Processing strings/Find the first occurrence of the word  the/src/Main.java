import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        String inputStrings = new Scanner(System.in).nextLine().toLowerCase();
        System.out.println(inputStrings.contains("the") ? inputStrings.indexOf("the") : -1);
    }
}
