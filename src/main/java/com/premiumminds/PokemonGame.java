package com.premiumminds;

import java.util.HashSet;
import java.util.Scanner;

public final class PokemonGame {

    // Private constructor to prevent instantiation
    private PokemonGame() {}

    /**
     * Returns the input of the user with the directions for Ash.
     * Only returns the input if the directions are valid.
     * If directions are wrong, asks the user for new directions.
     *
     * @return Array with separated user directions
     */
    public static String[] getDirections() {

        // Print Pokémon logo
        System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");

        System.out.println("Insert Ash's move sequence to get the total number of caught Pokémon: ");

        Scanner scanner = new Scanner(System.in);

        String directionString = scanner.nextLine();

        // Check if directions given are valid
        if (!validDirections(directionString)) {
            System.out.println("You gave Ash wrong directions! Please try again...\n");
            getDirections();
        }

        return splitDirections(directionString);
    }

    /**
     * Logic to get the number of all the caught Pokémon in the unique houses Ash moves into.
     *
     * @param directions inputed by the user, divided into an array
     */
    public static void catchPokemon(String[] directions) {

        // First house initial coordinates
        long x = 0;
        long y = 0;

        // Set to store all unique houses coordinates
        HashSet<Coordinates> houseCoordinates = new HashSet<>();

        // Add Ash's initial house coordinates, x = 0 and y = 0, to the set
        houseCoordinates.add(new Coordinates(x,y));

        // Iterate through the directions inputted by the user and rearrange coordinates accordingly
        for (String direction : directions) {

            switch (direction) {
                case "N" -> y++; // Ash moves North = y + 1
                case "S" -> y--; // Ash moves South = y - 1
                case "E" -> x++; // Ash moves East = x + 1
                case "O" -> x--; // Ash moves West = x - 1
            }

            // Save current house coordinates to the set
            houseCoordinates.add(new Coordinates(x,y));
        }

        // Return number of unique houses visited that equals the number of caught Pokémon
        System.out.print(houseCoordinates.size());
    }

    /**
     * Check with regex if the user input are valid directions.
     *
     * @param directionString
     * @return true (if input is valid) or false (if input is invalid)
     */
    private static boolean validDirections(String directionString) {

        return directionString.matches("^[nseoNSEO]+$");
    }

    /**
     * Splits the user input String into an array.
     *
     * @param directions String with user input
     * @return array with the user inputted directions
     */
    private static String[] splitDirections(String directions) {
        return directions.toUpperCase().split("");
    }

}
