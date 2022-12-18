class Solution {
    public boolean isPerfectSquare(int num) {
        int temp = (int) Math.sqrt(num);
        return temp * temp == num;
    }
}