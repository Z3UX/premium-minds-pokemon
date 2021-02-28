package com.premiumminds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CoordinatesTest {

 private final Coordinates coordinates = new Coordinates(0,0);

 @Test
 void compareSameXY() {
  assertEquals(new Coordinates(0,0),coordinates);
 }

 @Test
 void compareDifferentXY() {
  assertNotEquals(new Coordinates(0,1),coordinates);
 }

}
