import java.util.Arrays;

public class eWords {



        static String str = "Домашнее задание\n" +
                "\n" +
                "В тексте, который вы видите на этом изображении, посчитайте количество букв ‘е’ в каждом слове\n" +
                "\n" +
                "Напишите регулярное выражение для проверки телефона в международном формате \n" +
                "\n" +
                "С помощью регулярного выражения напишите функцию удаления всех букв и пробелов из текста\n";
        static String[] res;
        //static int[] eWords;

        public static void main(String[] args) {
            split();
            count();

        }
        public static void split() {

            String temp = str.replaceAll("[\n,:-]", " ");
            res = temp.replaceAll(" +", " ").split(" ");
            System.out.println(Arrays.toString(res));
            for (String str : res) {
                print(str);
            }

        }

        public static void count(){
            int[]eWords = new int[res.length];

            for (int i = 0; i < res.length; i++) {
                int numberOfE = 0;
                for(int j = 0; j < res[i].length(); j++) {
                    if (res[i].charAt(j) == 'е') {
                        numberOfE++;
                    }

                }
                eWords[i] = numberOfE;
            }
            System.out.println(Arrays.toString(eWords));
        }



        private static void print (String text){
            System.out.println(text);
        }




    }

