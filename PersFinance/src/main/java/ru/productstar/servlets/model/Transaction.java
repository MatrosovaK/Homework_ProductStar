package ru.productstar.servlets.model;

public class Transaction {
    private final String name;
    private final int sum;
    private final TransactionType type;

    public Transaction(String name, int sum, TransactionType type) {
        this.name = name;
        this.sum = sum;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", type=" + type +
                '}';
    }
}