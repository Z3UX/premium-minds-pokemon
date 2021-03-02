package com.premiumminds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PokemonLogicTest {

    @Test
    void testPokemonLogic() {
        assertEquals(2, PokemonLogic.moveAsh(new String[]{"E"}));
        assertEquals(4, PokemonLogic.moveAsh(new String[]{"N","E","S","O"}));
        assertEquals(2, PokemonLogic.moveAsh(new String[]{"N","S","N","S","N","S","N","S","N","S"}));
        assertEquals(71, PokemonLogic.moveAsh(new String[]{"N","N","N","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N","N",}));

    }
}
