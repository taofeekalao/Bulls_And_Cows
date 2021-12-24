// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here

    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();

    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.length() % 2 != 0) {
        if (i == inputString.length() / 2) {
          continue;
        }
        System.out.print(inputString.charAt(i));
      } else {
        if (i == inputString.length() / 2 - 1 || i == inputString.length() / 2) {
          continue;
        }
        System.out.print(inputString.charAt(i));
      }
    }
  }
}

/*import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    int middle = (str.length() - 1) / 2;
    System.out.print(str.substring(0, middle));
    System.out.print(str.substring(str.length() - middle, str.length()));
  }
}*/
