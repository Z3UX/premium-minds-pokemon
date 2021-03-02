package com.premiumminds;

class Main {

    public static void main(String[] args) {

        // Get user inputted directions
        String[] directions = PokemonLogic.getDirections();

        // Move Ash to user inputted directions and get the number of Pokémon caught
        long pokemonCaught = PokemonLogic.moveAsh(directions);

        // Print the number of Pokémon caught
        System.out.println(pokemonCaught);
    }
}
