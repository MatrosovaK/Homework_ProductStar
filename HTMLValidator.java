package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLValidator {

    public static boolean validate (String html) {
        Deque<String> tags = new ArrayDeque<>(); //вроде как бфло сказано, что не рекомендуется исп стек,
        // тк он старый, мдленный и тд, и лучше использовать deque


        String regex = "</?([A-Za-z0-9]+)>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String tag = matcher.group(0);
            String tagBody = matcher.group(1);


            if (!tag.startsWith("</")) {
                tags.push(tagBody);
                //System.out.println(tags);
            } else {
                if (tags.isEmpty()) {
                    return false;
                }

                String lastTagBody = tags.pop();
                if (!lastTagBody.equals(tagBody)) {
                    return false;
                }
            }
        }
        return tags.isEmpty();
    }
    
    
    public static void main(String[] args){
        System.out.println("Введите  HTML-тег для проверки ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        boolean result = HTMLValidator.validate(input);
        System.out.println(result);


    }

}
