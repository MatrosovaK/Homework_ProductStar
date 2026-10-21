package org.example.Mylibrary;

public class TextReverser {
    public static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
