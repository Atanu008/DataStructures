package org.atanu.java.ds.design;

//Leetcode 1603
//https://leetcode.com/problems/design-parking-system/
public class ParkingSystem {

    int[] parkingSlots;
    public ParkingSystem(int big, int medium, int small) {
        parkingSlots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        //--parkingSlots[carType - 1];
        //return parkingSlots[carType - 1] >= 0;

        return parkingSlots[carType - 1] --> 0; //You first compare, and then decrement the variable.

    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        System.out.println(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. It is already occupied.
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
