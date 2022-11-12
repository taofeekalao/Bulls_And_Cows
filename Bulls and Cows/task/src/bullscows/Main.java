package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int MAXIMUM_LENGTH = 36;
    static int bulls = -1;
    static int cows = -1;
    static StringBuilder distinctCode = new StringBuilder();

    public static void main(String[] args) {

        int numberOfUniqueSymbols = 0;
        int codeLength = 0;
        String code = "";
        Scanner scanner = new Scanner(System.in);
        StringBuilder systemGeneratedSecretCode = new StringBuilder();

        int gameCounter = 1;
        /*
            Get the length of the secret code
         */
        System.out.println("Input the length of the secret code:");
        if (scanner.hasNextInt()) {
            codeLength = scanner.nextInt();
        } else {
            String entry = scanner.nextLine();
            System.out.println("Error: " + entry + " isn't a valid number.");
            return;
        }
        if (codeLength < 1) {
            System.out.println("Error: length of secret code cannot be negative.");
            return;
        }

        if (codeLength > MAXIMUM_LENGTH) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
            return;
        } else {
            /*
                Get number of unique symbols needed in the secret code
             */
            System.out.println("Input the number of possible symbols in the code:");
            numberOfUniqueSymbols = scanner.nextInt();
            if (numberOfUniqueSymbols > MAXIMUM_LENGTH) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            }

            /*
                Check that secret code length required is not longer than available distinct character
             */
            if (numberOfUniqueSymbols < codeLength) {
                System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " with " + numberOfUniqueSymbols + " unique symbols.");
                return;
            }

            /*

             */
            generateRandomCode(codeLength, numberOfUniqueSymbols);
            distinctCode.reverse();
            for (int y = 0; y < codeLength; y++) {
                systemGeneratedSecretCode.append(distinctCode.charAt(y));
            }
        }
        letUsPlayTheGame(scanner, systemGeneratedSecretCode, gameCounter, numberOfUniqueSymbols);
    }

    private static void letUsPlayTheGame(Scanner scanner, StringBuilder systemGeneratedSecretCode, int gameCounter, int numberOfUniqueSymbols) {

        String rangeOfSymbolsUsed = numberOfUniqueSymbols > 9 ? "(0-9, " + (char) ('`' + 1) + "-" + (char) ('`' + (numberOfUniqueSymbols - 10)) + ")." :
                "(0-" + numberOfUniqueSymbols + ").";
        StringBuilder maskedSecretCode = new StringBuilder();
        for (int i = 0; i < systemGeneratedSecretCode.length(); i++) {
            maskedSecretCode.append('*');
        }
        System.out.println("The secret is prepared: " + maskedSecretCode + " " + rangeOfSymbolsUsed );
        System.out.println("Okay, let's start a game!");

        System.out.println("Turn " + gameCounter + ":");
        String inputCode = scanner.next();

        /*
            Check that length of code entered in not more than maximum code length.
         */
        while (inputCode.length() > MAXIMUM_LENGTH) {
            inputCode = scanner.next();
        }
        checkPasscode(systemGeneratedSecretCode.toString(), inputCode);
        outputGenerator(bulls, cows, systemGeneratedSecretCode.toString());
        while (bulls != systemGeneratedSecretCode.length()) {
            System.out.println("Turn " + (++gameCounter) + ":");
            inputCode = scanner.next();

            /*
                Check that length of code entered is not more than maximum code length.
            */
            while (inputCode.length() > MAXIMUM_LENGTH) {
                inputCode = scanner.next();
            }
            checkPasscode(systemGeneratedSecretCode.toString(), inputCode);
            outputGenerator(bulls, cows, systemGeneratedSecretCode.toString());
        }
    }

    /**
     * This method generates random code based on the length of secret code supplied by the user
     *
     * @param codeLength
     * @param numberOfUniqueSymbols
     */
    private static void generateRandomCode(int codeLength, int numberOfUniqueSymbols) {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        for (int j = 0; j < codeLength; j++) {
            int randomOnTheFly = random.nextInt(numberOfUniqueSymbols + 1);
            secretCode.append(randomOnTheFly > 9 ? (char) ('`' + (randomOnTheFly - 9)) : randomOnTheFly);
        }
        while (checkDistinctCharacter(secretCode) < codeLength) {
            generateRandomCode(codeLength, numberOfUniqueSymbols);
        }
    }

    /**
     * This validates @param secretCode generated to consist only distinct value
     *
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
