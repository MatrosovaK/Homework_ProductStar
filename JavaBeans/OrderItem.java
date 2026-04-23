package org.example.JavaBeans;

class OrderItem {

        private MenuItem menuItem;
        private Size size;
        private int quantity;

        public OrderItem(MenuItem menuItem, Size size, int quantity) {
            this.menuItem = menuItem;
            this.size = size;
            this.quantity = quantity;
        }

        public MenuItem getMenuItem() {
            return menuItem;
        }

        public Size getSize() {
            return size;
        }

        public int getQuantity() {
            return quantity;
        }


        public void increaseQuantity(int amount) {
            this.quantity += amount;
        }
}




