import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] inputStrings = scanner.nextLine().split(" ");
        int stringLength = 0;
        String result = "";

        for (String individualString : inputStrings) {
            if (stringLength < individualString.length()) {
                stringLength = individualString.length();
                result = individualString;
            }
        }

        System.out.println(result);
    }
}