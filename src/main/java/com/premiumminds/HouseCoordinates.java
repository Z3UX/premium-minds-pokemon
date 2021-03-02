package com.premiumminds;

import java.util.Objects;

/**
 * Class to store the X and Y coordinates of the houses Ash visits so that they can be compared
 */
class HouseCoordinates {

    long x;
    long y;

    // Constructor as every house needs to have coordinates)
    public HouseCoordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    // Override equals so that the program can compare houses by their X and Y coordinates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseCoordinates that = (HouseCoordinates) o;
        return x == that.x && y == that.y;
    }

    // Override hashcode so that only one house with the same coordinates can be saved on the HashSet with the houses visited
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
