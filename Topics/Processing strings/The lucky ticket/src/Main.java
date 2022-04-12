import java.util.Scanner;

class Main {

    static final int RANGE = 3;

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] inputData = scanner.next().toCharArray();

        int firstThreeSum = 0;
        int lastThreeSum = 0;
        
        for (int i = 0; i < RANGE; i++) {
            firstThreeSum += inputData[i];
        }
        
        for (int j = inputData.length - RANGE; j < inputData.length; j++) {
            lastThreeSum += inputData[j];
        }
        
        System.out.println(lastThreeSum == firstThreeSum ? "Lucky" : "Regular");
    }
}
