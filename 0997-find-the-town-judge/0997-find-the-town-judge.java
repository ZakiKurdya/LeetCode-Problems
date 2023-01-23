class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1)
            return 1;
        else {
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashSet<Integer> persons = new HashSet<>();
            for (int i = 0; i < trust.length;  i++) {
                freq.put(trust[i][1], freq.getOrDefault(trust[i][1], 0) + 1);
                persons.add(trust[i][0]);
            }
            if (n - persons.size() > 1)
                return -1;
            for (int i = 0; i < trust.length;  i++)
                if (freq.get(trust[i][1]) == persons.size())
                    return trust[i][1];
            return -1;
        }
    }
}