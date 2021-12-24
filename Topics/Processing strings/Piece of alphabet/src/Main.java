import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] inputData = scanner.next().toCharArray();
        boolean answer = false;
        if (inputData.length == 1) {
            answer = true;
        }
        if (!"".equals(inputData) && !"null".equals(inputData)) {
            for (int i = 1; i < inputData.length - 1; i++) {
                if (inputData[i] < inputData[i + 1] && inputData[i] + 1 == inputData[i + 1]) {
                    answer = true;
                } else {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        System.out.println(answer);
    }
}