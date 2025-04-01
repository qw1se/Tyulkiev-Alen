package org.example.homeworknumber1;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private double finalPrice;
    private String date;

    public Product(int id, String name, double price, int quantity, double finalPrice, String date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
