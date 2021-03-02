package com.premiumminds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HouseCoordinatesTest {
    private final HouseCoordinates houseCoordinates = new HouseCoordinates(0,0);

    @Test
    void compareSameXY() {
        assertEquals(new HouseCoordinates(0,0), houseCoordinates);
    }

    @Test
    void compareDifferentXY() {
        assertNotEquals(new HouseCoordinates(0,1), houseCoordinates);
    }

}