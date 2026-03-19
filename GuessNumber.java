package org.example;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main (String[] args){
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        Scanner in = new Scanner(System.in);
        int userNumber;
        int numberOfAttempts = 0;
        while(true){
            System.out.println("Введите число от 0 до 100");
            userNumber= in.nextInt();
            numberOfAttempts++;
            if(userNumber == numberToGuess){
                System.out.println("Вы угадали число c " + numberOfAttempts + " попытки");
                break;
            }else if(userNumber < numberToGuess) {
                System.out.println("Ваше число меньше");
            } else{
                System.out.println("Ваше число больше");
            }

            }
        in.close();
        }


}
