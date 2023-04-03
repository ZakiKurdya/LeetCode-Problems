class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int minBoats = 0, l = 0, r = people.length - 1;
        
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                minBoats++;
                l++;
                r--;
            } else {
                minBoats++;
                r--;
            }
        }
        
        return minBoats;
    }
}