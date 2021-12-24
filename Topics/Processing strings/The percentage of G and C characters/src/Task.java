import java.util.Scanner;

class Main {
      
    public static void main(String[] args) {
    
        final int PERCENTAGE = 100;
        Scanner scanner = new Scanner(System.in);
        char[] inputString = scanner.nextLine().toLowerCase().toCharArray();
        
        int counter = 0;
        for (char ch : inputString) {
            if (ch == 'c' || ch == 'g') {
                counter++;
            }
        }
        System.out.println((double) counter / inputString.length * PERCENTAGE);
    }
}
