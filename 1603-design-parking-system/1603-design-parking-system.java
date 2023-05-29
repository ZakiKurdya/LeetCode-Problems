class ParkingSystem {
    private int[] parkingLot = new int[3];
    
    public ParkingSystem(int big, int medium, int small) {
        parkingLot[0] = big;
        parkingLot[1] = medium;
        parkingLot[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (parkingLot[carType - 1] == 0)
            return false;
        
        parkingLot[carType - 1]--;
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */