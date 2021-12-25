package bullscows;

import java.util.Scanner;

public class Main {

    static int bulls = 0;
    static int cows = 0;

    public static void main(String[] args) {

        String secretCode =  Integer.toString(9305);
        Scanner scanner = new Scanner(System.in);
        String inputCode = Integer.toString(scanner.nextInt());

        checkPasscode(secretCode, inputCode);
        outputGenerator(bulls, cows, secretCode);
    }


    /**
     * Method to check correctness of user supplied passcode
     * against store passcode
     * @param passCode
     * @param cusPassCode
     */
    static void checkPasscode (String passCode, String  cusPassCode) {
        for (int i = 0; i < passCode.length(); i++) {
            for (int j = 0; j < cusPassCode.length(); j++) {
                if (passCode.charAt(i) == cusPassCode.charAt(j)) {
                    cows++;
                    if (i == j) {
                        bulls++;
                        cows--;
                    }
                }
            }
        }
    }


    /**
     * Method to generate customised output for the class
     * @param bulls
     * @param cows
     * @param secretCode
     */
    static void outputGenerator(int bulls, int cows, String  secretCode) {
        if (bulls == 0 && cows != 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secretCode + ".");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None. The secret code is " + secretCode + ".");
        } else if (bulls != 0 && cows == 0) {
            System.out.println("Grade: "+ bulls + " bull(s). The secret code is " + secretCode + ".");
        } else {
            System.out.println("Grade: "+ bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode + ".");
        }
    }
}
