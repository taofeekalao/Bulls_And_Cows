import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        
        Scanner scanner = new Scanner(System.in);
        StringBuffer inputString = new StringBuffer(scanner.nextLine().toLowerCase());
        StringBuffer reverseString = new StringBuffer(inputString).reverse();

        if (inputString.compareTo(reverseString) == 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
