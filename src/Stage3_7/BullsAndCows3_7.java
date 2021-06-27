package Stage3_7;
/*
Objective
In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it.
If the length is greater than 10, the program should print a message containing the word Error.
The secret code may contain any digits from 0 to 9 but only once. The secret code shouldn't start with a digit 0: for the first digit of the secret code, use digits from 1 to 9.

Don't delete your previous work, just move your code to a separate method. You will need it in the future stages.
Examples
The greater-than symbol followed by a space > represents the user input. Note that it's not part of the input.

Example 1

> 5
The random secret number is 48379.
Example 2

> 4
The random secret number is 5213.
Example 3

> 11
Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.
 */

import java.util.Random;
import java.util.Scanner;

public class BullsAndCows3_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int inputNumber = scanner.nextInt();

        long pseudoRandomNumber = System.nanoTime();
        StringBuilder str = new StringBuilder();
        if (inputNumber > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + inputNumber + " because there aren't enough unique digits.");
        } else {
            for (int i = 0; i < inputNumber; i++) {
                if (Long.toString(pseudoRandomNumber).charAt(0) != 0) {
                    str.append(Long.toString(pseudoRandomNumber).charAt(i));
                }

            }
            System.out.print("The random secret number is " + str + ".");

        }
    }
}