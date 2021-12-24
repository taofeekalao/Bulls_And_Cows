import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);  
        String inputStrings = scanner.nextLine().toLowerCase();
        String searchString = scanner.next().toLowerCase();

        int occurrenceCounter = 0;
        for (int j = 0; j < inputStrings.length();) {
            String tempString = inputStrings.substring(j);
            if (tempString.contains(searchString)) {
                occurrenceCounter++;
            }
            j += tempString.indexOf(searchString) + searchString.length();
        }
        System.out.println(occurrenceCounter);
    }
}
