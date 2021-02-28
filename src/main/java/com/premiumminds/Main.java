package com.premiumminds;

import java.util.HashSet;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Ash's move sequence to obtain number of caught Pokémon:");

        String directionString = scanner.nextLine();

        // Check if directions given are valid
        if (!directionString.matches("^[nseoNSEO]+$")) {
            System.out.println("You gave Ash wrong directions!\n");
            System.exit(0);
        }

        // Split string into individual directions
        String[] directions = directionString.toUpperCase().split("");

        // First house initial coordinates
        long x = 0;
        long y = 0;

        // Set to store all unique houses coordinates
        HashSet<Coordinates> pastCoordinates = new HashSet<>();

        // Add Ash's initial coordinates to the set
        pastCoordinates.add(new Coordinates(x,y));

        // Iterate through the directions
        for (String direction : directions) {

            // When Ash moves N = y+1, S = y-1, E = x+1, O = x-1
            switch (direction) {
                case "N" -> y++;
                case "S" -> y--;
                case "E" -> x++;
                case "O" -> x--;
            }

            // Add Ash's current coordinates to the set
            pastCoordinates.add(new Coordinates(x,y));
        }

        // Return number of caught Pokémon
        System.out.print(pastCoordinates.size());
    }
}
