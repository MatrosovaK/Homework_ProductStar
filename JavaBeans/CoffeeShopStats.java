package org.example.JavaBeans;

public class CoffeeShopStats {
    private static int totalOrders = 0;
    private static int totalItemsSold = 0;
    private static double totalRevenue = 0;




    public static void addOrder(CoffeeShop.Order order) {
        totalOrders++;

        for (OrderItem item : order.getOrderItems()){
            totalItemsSold += item.getQuantity();
            totalRevenue += item.getMenuItem().getPrice() * item.getQuantity();
        }
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public static int getTotalItemsSold() {
        return totalItemsSold;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static String getStats() {
        return "Всего заказов: " + totalOrders + ". Всего проданных товаров: " + totalItemsSold
                + ". Общая прибыль составляет: " + totalRevenue;
    }
}

