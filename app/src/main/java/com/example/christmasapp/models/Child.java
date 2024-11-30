package com.example.christmasapp.models;

import java.util.ArrayList;

public class Child {
    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private String city;
    private String username;
    private String password;
    private ArrayList<Gift> gifts; // Liste des cadeaux

    // Constructeur
    public Child(String firstName, String lastName, int age, String country, String city, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.city = city;
        this.username = username;
        this.password = password;
        this.gifts = new ArrayList<>(); // Initialisation de la liste des cadeaux
    }

    // Getters et setters pour les informations de l'enfant
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Gestion des cadeaux
    public ArrayList<Gift> getGifts() { return gifts; } // Récupérer les cadeaux
    public void addGift(Gift gift) { gifts.add(gift); }  // Ajouter un cadeau
}
