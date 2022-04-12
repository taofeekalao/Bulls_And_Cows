package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int bulls = -1;
    static int cows = -1;
    static StringBuilder distinctCode = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder systemGeneratedSecretCode = new StringBuilder();
        StringBuilder secretCode = new StringBuilder();

        int gameCounter = 1;

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
                systemGeneratedSecretCode.append(distinctCode.charAt(y));
            }
        }
        System.out.println("Okay, let's start a game!");

        System.out.println("Turn " + gameCounter + ":");
        String inputCode = Integer.toString(scanner.nextInt());
        checkPasscode(systemGeneratedSecretCode.toString(), inputCode);
        outputGenerator(bulls, cows, systemGeneratedSecretCode.toString());
        while (bulls != systemGeneratedSecretCode.length()) {
            System.out.println("Turn " + (++gameCounter) + ":");
            inputCode = Integer.toString(scanner.nextInt());
            checkPasscode(systemGeneratedSecretCode.toString(), inputCode);
            outputGenerator(bulls, cows, systemGeneratedSecretCode.toString());
        }
    }

    /**
     * This method generates random code based on the length of secret code supplied by the user
     * @param codeLength
     */


//    private static StringBuilder generateRandomCode(int codeLength) {
//        long pseudoRandomNumber = System.nanoTime();
//        StringBuilder secretCode = new StringBuilder(String.valueOf(pseudoRandomNumber));
//        while (checkDistinctCharacter(secretCode) < codeLength) {
//            pseudoRandomNumber = System.nanoTime();
//            secretCode = new StringBuilder(String.valueOf(pseudoRandomNumber));
//        }
//            return secretCode;
//    }
    private static StringBuilder generateRandomCode(int codeLength) {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        for (int j = 0; j < codeLength ; j++) {
            secretCode.append(random.nextInt(10));
        }
        while (checkDistinctCharacter(secretCode) < codeLength) {
            generateRandomCode(codeLength);
        }
        return secretCode;
    }
    /**
     * This validates @param secretCode generated to consist only distinct value
     * @param secretCode
     * @return
     */
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
        bulls = 0;
        cows = 0;
        for (int i = 0; i < passCode.length(); i++) {
            for (int j = 0; j < cusPassCode.length(); j++) {
                if (passCode.charAt(i) == cusPassCode.charAt(j)) {
                    cows++;
                    if (i == j) {
                        ++bulls;
                        --cows;
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
        if (bulls == secretCode.length()) {
            System.out.println("Grade: " + bulls + " bulls\n" +
                    "Congratulations! You guessed the secret code.");
        } else if (bulls == 0 && cows != 0) {
            System.out.println("Grade: " + cows + " cow(s).");
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (bulls != 0 && cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        }
    }
}
