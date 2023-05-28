class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++)
            map.put(score[i], i);
        
        int i = 0;
        String[] result = new String[score.length];
        for (int idx : map.values()) {
            if (i == 0)
                result[idx] = "Gold Medal";
            else if (i == 1)
                result[idx] = "Silver Medal";
            else if (i == 2)
                result[idx] = "Bronze Medal";
            else
                result[idx] = String.valueOf(i + 1);
            
            i++;
        }
        
        return result;
    }
}