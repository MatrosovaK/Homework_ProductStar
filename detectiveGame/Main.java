package org.detectiveGame;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в детективную игру!");
        Scanner in = new Scanner(System. in);
        EvidenceData ed = new EvidenceData();
        EvidenceDatabase edb = new EvidenceDatabase();

        int input = 0;
        while(input != 6){

            System.out.println("Выберите пункт меню: \n"+
                    "1 - Добавить улику\n" +
                    "2 - Проверить наличие улики\n" +
                    "3 - Удалить улику\n" +
                    "4 - Сравнить с базой данных\n" +
                    "5 - Показать все найденные улики\n" +
                    "6 - Выход");

            if(in.hasNextInt()) {
                input = in.nextInt();
                in.nextLine();
            } else {
                System.out.println("Ошибка: введите число от 1 до 6");
                in.nextLine();
                continue;
            }


            if(input == 1){
                System.out.println("Введите название новой улики: ");
                String newEvidence = in.nextLine();
                ed.addEvidence(newEvidence);
                System.out.println("Улика \"" + newEvidence + "\" добавлена");
            }else if(input == 2){
                System.out.println("Введите название улики для проверки:");
                String evidenceForCheck = in.nextLine();
                if (ed.checkForEvidence(evidenceForCheck)){
                    System.out.println("Улика найдена");
                } else{
                    System.out.println("Улика не найдена");
                }
            } else if (input == 3){
                System.out.println("Введите название улики для удаления:");
                String evidenceForDelete = in.nextLine();

                if(ed.deleteEvidence(evidenceForDelete)){
                    System.out.println("Улика \"" + evidenceForDelete + "\" удалена");
                }
                else{
                    System.out.println("Ошибка. \"" + evidenceForDelete + "\" не была найдена");
                }


            } else if(input == 4){
                if(!edb.databaseMatches(ed).isEmpty()){
                    System.out.println("Совпадения с базой данных: " + edb.getListOfCoincidences(ed));
                } else {
                    System.out.println("Совпадения с базой данных не найдены");
                }

            } else if(input == 5) {
                if (ed.getEvidences().isEmpty()) {
                    System.out.println("Список улик пуст");
                } else {
                    System.out.println("Найденные улики: " + ed.showAllEvidenceFound());
                }
            } else if(input == 6) {
                System.out.println("Завершение программы");
            } else {
                System.out.println("Введите корректное значение");
            }

        }


    }



}
