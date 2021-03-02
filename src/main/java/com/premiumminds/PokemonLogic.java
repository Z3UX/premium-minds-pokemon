package com.premiumminds;

import java.util.HashSet;
import java.util.Scanner;

public final class PokemonLogic {

    // Private constructor to prevent instantiation
    private PokemonLogic() {}

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

        // Get user input from Scanner
        Scanner scanner = new Scanner(System.in);

        String directionString = scanner.nextLine();

        // Check if directions given are valid
        if (!validDirections(directionString)) {
            System.out.println("You gave Ash wrong directions! Please try again...\n");
            getDirections();
        }

        // Return directions split into an Array
        return splitDirections(directionString);
    }

    /**
     * Logic to move Ash through the several directions inputted and get the number unique houses he visits.
     *
     * @param directions inputted by the user, divided into an array
     * @return number of unique houses visited witch will be the same as the number of caught Pokémon
     */
    public static long moveAsh(String[] directions) {

        // First house visited by Ash and initial coordinates
        long x = 0;
        long y = 0;

        // Set to store all the coordinates of the houses Ash visits
        HashSet<HouseCoordinates> housesVisited = new HashSet<>();

        // Add Ash's initial house coordinates, x = 0 and y = 0, to the set
        housesVisited.add(new HouseCoordinates(x,y));

        // Iterate through the directions inputted by the user and rearrange current house coordinates accordingly
        for (String direction : directions) {

            switch (direction) {
                case "N" -> y++; // Ash moves North = y + 1
                case "S" -> y--; // Ash moves South = y - 1
                case "E" -> x++; // Ash moves East = x + 1
                case "O" -> x--; // Ash moves West = x - 1
            }

            // Save current house coordinates to the houses visited set
            housesVisited.add(new HouseCoordinates(x,y));
        }

        // Return the number of unique houses visited witch will be the same as the number of caught Pokémon
        return housesVisited.size();
    }

    /**
     * Check with regex if the user input are valid directions.
     *
     * @param directionString String with the user input
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
