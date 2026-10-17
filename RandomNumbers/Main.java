package org.RandomNumbers;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generateNumber(10, 9999);
        }

        AtomicInteger twoDigit = new AtomicInteger(0);
        AtomicInteger threeDigit = new AtomicInteger(0);
        AtomicInteger fourDigit = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            for (int number : numbers) {
                if (number >= 10 && number <= 99) {
                    twoDigit.incrementAndGet();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int number : numbers) {
                if (number >= 100 && number <= 999) {
                    threeDigit.incrementAndGet();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int number : numbers) {
                if (number >= 1000 && number <= 9999) {
                    fourDigit.incrementAndGet();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание потоков было прервано");
            return;
        }
        System.out.println("Двузначных чисел: " + twoDigit.get() + " шт.");
        System.out.println("Трехзначных чисел: " + threeDigit.get() + " шт.");
        System.out.println("Четырехзначных чисел: " + fourDigit.get() + " шт.");


        int total = twoDigit.get() + threeDigit.get() + fourDigit.get();

        System.out.println("\nВсего посчитано: " + total);
    }


    public static int generateNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}







