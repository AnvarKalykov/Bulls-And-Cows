package Stage6_7;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCows6_7 {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

class Grade {
    int bulls;
    int cows;

    public Grade(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }
}


class Game {
    int turn = 1;
    String secret;

    private static int getSecretLength() {
        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int getNumberPossibleSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();


    }



    private static String getSecret(int secretLength) {
        assert secretLength > 0 && secretLength <= 36;

        Random random = new Random();
        StringBuilder secret = new StringBuilder(secretLength);

        while (secret.length() < secretLength) {
            String digit = String.valueOf(random.nextInt(36));
            if (secret.indexOf(digit) == -1) {
                secret.append(digit);
            }
        }

        return secret.toString();

    }

    private static String getGuess() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private Grade getGrade(String guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else if (secret.indexOf(guess.charAt(i)) != -1) {
                cows++;
            }
        }
        return new Grade(bulls, cows);
    }

    private void printGrade(Grade grade) {
        String gradeString;

        if (grade.bulls != 0 && grade.cows != 0) {
            gradeString = String.format("%d bull(s) and %d cow(s)", grade.bulls, grade.cows);
        } else if (grade.bulls != 0) {
            gradeString = String.format("%d bull(s)", grade.bulls);
        } else if (grade.cows != 0) {
            gradeString = String.format("%d cow(s)", grade.cows);
        } else {
            gradeString = "None";
        }

        System.out.printf("Grade: %s", gradeString);
        System.out.println();
    }

    void play() {
        String guess;
        int secretLength = getSecretLength();
        int possibleSymbol = getNumberPossibleSymbols();
        StringBuilder str = new StringBuilder();
        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v",  "w",  "x", "y", "z"};

        while (secretLength > 36) {
            System.out.println("Error: secret length cannot be greater than 36");
            secretLength = getSecretLength();
        }

        str.append("*".repeat(Math.max(0, secretLength)));

        if (possibleSymbol < 10) {
            System.out.println("The secret is prepared: " + str + " (" + symbols[0] + "-" + symbols[possibleSymbol]+ ").");
        } else {
            System.out.println("The secret is prepared: " + str + " (0-9, " + symbols[10] + "-" + symbols[possibleSymbol - 1]+ ").");
        }





        secret = getSecret(secretLength);

        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n",turn);
            guess = getGuess();
            Grade grade = getGrade(guess);
            printGrade(grade);
            turn++;

        } while (!guess.equals(secret));

        System.out.println("Congratulations! You guessed the secret code.");
    }
}

