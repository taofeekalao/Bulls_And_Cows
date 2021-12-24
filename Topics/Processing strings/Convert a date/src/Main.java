import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        String day = date.substring(8,10);
        String month = date.substring(5,7);
        String year = date.substring(0,4);

        System.out.println(month + "/" + day + "/" + year);
    }
}