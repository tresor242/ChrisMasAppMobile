package com.example.christmasapp.models;

public class Gift {
    private String type;
    private String name;
    private String description;
    private double price;

    public Gift(String type, String name, String description, double price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters et Setters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
