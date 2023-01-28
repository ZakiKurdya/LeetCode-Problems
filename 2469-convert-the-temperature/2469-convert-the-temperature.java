class Solution {
    public double[] convertTemperature(double celsius) {
        double[] temperature = new double[2];
        temperature[0] = celsius + 273.15;
        temperature[1] = celsius * 1.80 + 32;
        return temperature;
    }
}