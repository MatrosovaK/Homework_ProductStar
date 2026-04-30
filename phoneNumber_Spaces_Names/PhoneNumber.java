package org.phoneNumber_Spaces_Names;

import java.util.Scanner;
import java.util.regex.Pattern;



public class PhoneNumber {

    public static boolean isCorrectNumber(String phoneNumber){

        String regex = "^\\+\\d{1,3}(?: |-)?\\d{1,3}(?: |-)?\\d{3}(?: |-)?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();


    }


    public static void main(String[]args){
        System.out.println("Введите номер для проверки: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        boolean result = PhoneNumber.isCorrectNumber(input);
        if (result){
            System.out.println("номер соответствует международному формату");
        }else{
            System.out.println("номер не соответствует международному формату");
        }

    }
}
