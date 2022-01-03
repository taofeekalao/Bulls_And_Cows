package bullscows;

import java.util.Scanner;

public class Main {

    static int bulls = 0;
    static int cows = 0;
    static StringBuilder distinctCode = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder userSecretCode = new StringBuilder();

        int codeLength = scanner.nextInt();
        while (codeLength < 1) {
            codeLength = scanner.nextInt();
        }
        if (codeLength > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
        } else {
            generateRandomCode(codeLength);
            distinctCode.reverse();
            while (Integer.parseInt(String.valueOf(distinctCode.charAt(0))) == 0) {
                generateRandomCode(codeLength);
                distinctCode.reverse();
            }
            for (int y = 0; y < codeLength; y++) {
                userSecretCode.append(distinctCode.charAt(y));
            }
            System.out.println("The random secret number is " + userSecretCode + ".");
        }
    }

    private static void generateRandomCode(int codeLength) {
        long pseudoRandomNumber = System.nanoTime();
        StringBuilder secretCode = new StringBuilder(String.valueOf(pseudoRandomNumber));
        while (checkDistinctCharacter(secretCode) < codeLength) {
            pseudoRandomNumber = System.nanoTime();
            secretCode = new StringBuilder(String.valueOf(pseudoRandomNumber));
        }
    }

/*    public static void main(String[] args) {

        String secretCode =  Integer.toString(9305);
        Scanner scanner = new Scanner(System.in);
        String inputCode = Integer.toString(scanner.nextInt());

        checkPasscode(secretCode, inputCode);
        outputGenerator(bulls, cows, secretCode);
    }*/

    static int checkDistinctCharacter(StringBuilder secretCode) {
        for (int j = 0; j < secretCode.length(); j++) {
            if (!distinctCode.toString().contains(secretCode.substring(j, j + 1))) {
                distinctCode.append(secretCode.charAt(j));
            }
        }
        return distinctCode.length();
    }

    /**
     * Method to check correctness of user supplied passcode
     * against store passcode
     *
     * @param passCode
     * @param cusPassCode
     */
    static void checkPasscode(String passCode, String cusPassCode) {
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
     *
     * @param bulls
     * @param cows
     * @param secretCode
     */
    static void outputGenerator(int bulls, int cows, String secretCode) {
        if (bulls == 0 && cows != 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secretCode + ".");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None. The secret code is " + secretCode + ".");
        } else if (bulls != 0 && cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + secretCode + ".");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode + ".");
        }
    }
}
