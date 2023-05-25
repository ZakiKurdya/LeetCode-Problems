class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) 
            freq.put(hand[i], freq.getOrDefault(hand[i], 0) + 1);
        
        while (!freq.isEmpty()) {
            int k = freq.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                if (freq.containsKey(k))
                    freq.put(k, freq.get(k) - 1);
                else
                    return false;
                
                if (freq.get(k) == 0)
                    freq.remove(k);
                
                k++;
            }
        }
        
        return true;
    }
}