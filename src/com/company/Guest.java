package com.company;

public class Guest {
    String name;
    String meal;
    int phoneNumber;
    boolean isVegan;

    public Guest(String name, String meal, int phoneNumber, boolean isVegan) {
        this.name = name;
        this.meal = meal;
        this.phoneNumber = phoneNumber;
        this.isVegan = isVegan;
    }

    public String getName() {
        return name;
    }

    public String getMeal() {
        return meal;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isVegan() {
        return isVegan;
    }



    public void displayGuestInformation(){
        System.out.println();
        System.out.println("Imię: " + name);
        System.out.println("Posiłek: " + meal);
        System.out.println("Numer telefonu: " + phoneNumber);
        String isVeganString = isVegan? "tak" : "nie";
        System.out.println("Weganin?: " + isVeganString);
        System.out.println();

    }
}
