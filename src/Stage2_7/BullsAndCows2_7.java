package Stage2_7;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCows2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int guessedNumber = random.nextInt((9999 - 100) + 1) + 10;
        int inputNumber = scanner.nextInt();
        int cow = 0;
        int bull = 0;

        String guessedString = Integer.toString(guessedNumber);
        String inputString = Integer.toString(inputNumber);

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == guessedString.charAt(i) ) {
                bull++;
            } else if (guessedString.indexOf(inputString.charAt(i)) != -1) {
                cow++;
            }
        }



        if (cow == 0 ) {
            System.out.println("Grade: None. The secret code is " + guessedNumber + ".");
        } else if (cow > 0 && bull == 0) {
            System.out.println("Grade: " + cow + " cow(s). The secret code is " + guessedNumber + ".");
        } else if (cow > 0 && bull > 0) {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s). The secret code is " + guessedNumber + ".");
        }





    }
}
