package org.example.JavaBeans;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    private final List<MenuItem> menu;
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public CoffeeShop() {
        menu = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        menu.add(item);
    }

    public void addOrder (Order order){
        orders.add(order);


    }



    public class Order{
        private final List<OrderItem>orderItems = new ArrayList<>();

        public List<OrderItem> getOrderItems() {
            return orderItems;
        }

        public void addItemToOrder(MenuItem menuItem, Size size, int quantity){
            for (OrderItem orderItem: orderItems) {
                if (orderItem.getMenuItem().equals(menuItem) &&
                        orderItem.getSize().equals(size)) {
                    orderItem.increaseQuantity(quantity);
                    return;
                }
            }
                    orderItems.add(new OrderItem(menuItem, size, quantity));

        }
    }


}

