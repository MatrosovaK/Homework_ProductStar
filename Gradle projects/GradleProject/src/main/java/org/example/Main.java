
package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.Mylibrary.TextReverser;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, World!";
        String reversed = StringUtils.reverse(text);
        System.out.println(reversed);

        System.out.println(
                TextReverser.reverse("Hello from my library!")
        );
    }
}
