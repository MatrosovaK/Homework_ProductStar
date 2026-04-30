package org.phoneNumber_Spaces_Names;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Names {
     public static boolean isUserNameCorrect(String input) {
          String regex = "^[a-zA-Z][a-zA-Z0-9_]{2,19}$";
          Pattern pattern = Pattern.compile(regex);
          return pattern.matcher(input).matches();
     }

     public static String getValidationError(String input) {
          if (!input.matches("^[a-zA-Z].*")) {
               return "Ошибка: имя пользователя должно начинаться с буквы";

          } else if (input.length() < 3 || input.length() > 20) {
               return "Ошибка: имя пользователя должно содержать от 3 до 20 символов";
          } else if (!input.matches("^[a-zA-Z0-9_]+$")) {
               return "Ошибка: допустимы только буквы, цифры и нижнее подчеркивание";
          } else {
               return "OK";
          }
     }


     public static String formatUserName(String input) {

          return input.replaceAll("_+", "_").toLowerCase();
     }


     public static void main(String[] args) {
          System.out.println("Введите user name: ");
          Scanner in = new Scanner(System.in);
          String input = in.nextLine();
          if(Names.isUserNameCorrect(input)){
               System.out.println(Names.formatUserName(input));
          } else {
               System.out.println(Names.getValidationError(input));
          }


          in.close();
     }
}

