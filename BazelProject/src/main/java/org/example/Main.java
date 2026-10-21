package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.MyLibrary.Greeting;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, World!";

        // Внешняя библиотека
        String reversed = StringUtils.reverse(text);
        System.out.println(reversed);

        // Своя локальная библиотека
        System.out.println(Greeting.greet("Teacher"));
    }
}
