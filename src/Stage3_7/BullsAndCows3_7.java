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

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 10) {
            System.out.println("Error: can't generate a secret number with a length of" + n
                    + " because there aren't enough unique digits.");
        } else {

            String randomNumber = "";

            while (randomNumber.length() < n) {

                String rand = String.valueOf(System.nanoTime());

                for (int i = 0; i < rand.length(); i++) {

                    if (randomNumber.length() < n && !randomNumber.contains(String.valueOf(rand.charAt(i)))) {

                        randomNumber += rand.charAt(i);
                    }
                }
            }
            System.out.println("The random secret number is " + randomNumber + ".");
        }
    }
}