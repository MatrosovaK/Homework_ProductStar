package org.phoneNumber_Spaces_Names;

import java.util.Scanner;

public class Spaces {

    public static String deleteSpacesAndLetters(String input){
        return input.replaceAll("[а-яА-Яa-zA-Z\\s]", "");
    }

    public static void main (String[]args){
        System.out.println("Введите строку для удаления пробелов и букв: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();


        System.out.println(Spaces.deleteSpacesAndLetters(input));
        in.close();
    }
}
