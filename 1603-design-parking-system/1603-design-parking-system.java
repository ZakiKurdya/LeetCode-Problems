class ParkingSystem {
    private short big, medium, small;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = (short) big;
        this.medium = (short) medium;
        this.small = (short) small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            big--;
            return big >= 0; 
        } else if (carType == 2) {
            medium--;
            return medium >= 0; 
        } else {
            small--;
            return small >= 0; 
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */