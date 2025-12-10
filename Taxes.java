import java.util.ArrayList;

public class Taxes {


    public static void main(String[] args) {
        ArrayList<Double>prices = new ArrayList<>();

        //double[] prices = new double[args.length];
        int no = 0;
        for (int i = 0; i < args.length; i++) {

            try {
                double x = Double.parseDouble(args[i]);
                if (x >= 0){
                    prices.add(x);
                } else {
                    no++;
                }

            } catch (NumberFormatException e) {
                no++;

            }

        }
        System.out.println("Обнаружены " + no + " некорректные записи. Они будут удалены.");

        //for (double n : prices) {
            System.out.println(prices);


        double[] taxes = new double[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            if (0 < prices.get(i) && prices.get(i) <= 100) {
                double tax = 0.1 * prices.get(i) + prices.get(i);
                taxes[i] = tax;
            } else if (100 < prices.get(i) && prices.get(i) <= 1000) {
                double tax = 0.2 * prices.get(i) + prices.get(i);
                taxes[i] = tax;
            } else if (1000 < prices.get(i) && prices.get(i) <= 10000) {
                double tax = 0.3 * prices.get(i) + prices.get(i);
                taxes[i] = tax;
            } else {
                taxes[i] = prices.get(i);
            }
        }
        for (double n : taxes) {
                System.out.println(n);
                }



    }

}


