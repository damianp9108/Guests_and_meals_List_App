package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws emptyChoice  {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        Party party = new Party();
        int userChoise = 0;

        while (shouldContinue){
            System.out.println();
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wyświetl gości");
            System.out.println("2. Dodaj gościa");
            System.out.println("3. Wyświetl potrawy");
            System.out.println("4. Znajdź po numerze telefonu");
            System.out.println("5. Wyjście");
            System.out.println();

            try {
                userChoise = Integer.valueOf(scanner.nextLine());
            }
            catch (NumberFormatException n ) {
                System.out.println("to nie jest liczba");
            }


            if (userChoise < 1 || userChoise > 5) {
                    System.out.println("podaj cyfre od 1 do 5!!! !");
                } else {

                    switch (userChoise) {
                        case 1 -> party.displayGuests();
                        case 2 -> {
                            boolean b = false;
                            while (!b) {
                                try {
                                    party.addGuest();
                                    b = true;
                                } catch (emptyChoice e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                        case 3 -> party.displayMeals();
                        case 4 -> party.displayGuestByPhoneNumber();
                        case 5 -> shouldContinue = false;
                    }
                }
        }
    }


}



