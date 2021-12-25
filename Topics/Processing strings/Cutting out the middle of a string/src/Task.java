import java.util.Scanner;

public class Task {
/*    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.length() % 2 != 0) {
                if (i == inputString.length() / 2) {
                    continue;
                }
                System.out.print(inputString.charAt(i));
            } else {
                if (i == inputString.length() / 2 - 1 || i == inputString.length() / 2) {
                    continue;
                }
                System.out.print(inputString.charAt(i));
            }
        }
    }*/

    public static void main(String[] args) {
        // put your code here

        StringBuilder inputStringBuilder = new StringBuilder(new java.util.Scanner(System.in).nextLine());
        System.out.println(inputStringBuilder.length() % 2 != 0 ?
                inputStringBuilder.deleteCharAt(inputStringBuilder.length() / 2) :
                inputStringBuilder.delete(inputStringBuilder.length() / 2 - 1, inputStringBuilder.length() / 2 + 1));
    }
}
