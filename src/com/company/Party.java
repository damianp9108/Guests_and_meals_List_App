package com.company;

import java.util.*;

public class Party {
    private List<Guest> guests = new ArrayList<>();
    private Set<String> meals = new HashSet<>();
    private Map<Integer, Guest> phoneToGuest = new HashMap<>();

    Scanner scanner = new Scanner(System.in);



    public void addGuest() throws emptyChoice{
        System.out.println("Podaj imię gościa");
        String name = scanner.nextLine();
        if (name.isBlank()){
            throw new emptyChoice();
        }


        System.out.println("Podaj posiłek");
        String meal = scanner.nextLine();

        boolean numb = false;
        int phoneNumber = 0;
        while (!numb) {
            try {
                System.out.println("Podaj numer telefonu");
                phoneNumber = Integer.valueOf(scanner.nextLine());
                if (phoneNumber > 99999999 && phoneNumber < 1000000000) {
                    numb = true;
                } else
                    System.out.println("Numer musi się składać z 9 cyfr !!!");

            } catch (NumberFormatException n) {
                System.out.println("Tylko cyfry !!!");

            }

        }

        boolean repeat = false;
        boolean isVegan = false;
        while (!repeat) {
            System.out.println("Czy jest weganinem?  Y/N");
            String isVeganinString = scanner.nextLine();

            if (isVeganinString.equals("Y") && isVeganinString.length() == 1) {
                isVegan = true;
                repeat = true;
            } else if (isVeganinString.equals("N") && isVeganinString.length() == 1) {
                repeat = true;
                isVegan = false;
            } else {
                System.out.println("wpisz 'Y' lub 'N'  !!!");
            }
        }


        Guest guest = new Guest(name, meal, phoneNumber, isVegan);
        meals.add(meal);
        phoneToGuest.put(phoneNumber, guest);
        guests.add(guest);
    }

    public void displayGuests(){
       for (Guest guest: guests){
           guest.displayGuestInformation();
       }
    }

    public void displayMeals(){
        System.out.println();
        for(String meal: meals){
            System.out.println(meal);
        }
    }

    public void displayGuestByPhoneNumber(){
        boolean nb = false;
        while (!nb) {
            try {
                System.out.println("Podaj numer telefonu: ");
                Integer phoneNumber = Integer.valueOf(scanner.nextLine());
                if (phoneToGuest.containsKey(phoneNumber)) {
                    Guest guest = phoneToGuest.get(phoneNumber);
                    guest.displayGuestInformation();
                    nb = true;
                } else {
                    System.out.println("Nie ma takiego numeru w bazie");
                    nb = true;
                }

            }

            catch (NumberFormatException n) {
                System.out.println("tylko cyfry !!!");

            }

        }


    }
}
