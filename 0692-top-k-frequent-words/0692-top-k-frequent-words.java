class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : words)
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        
        TreeMap<Integer, List<String>> freqRev = new TreeMap(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            List<String> temp;
            
            if (!freqRev.containsKey(entry.getValue()))
                temp = new ArrayList<>();
            else
                temp = freqRev.get(entry.getValue());
            
            temp.add(entry.getKey());
            
            freqRev.put(entry.getValue(), temp);
        }
        
        List<String> result = new ArrayList<>();
        int cnt = 0;
        
        outer:
        for (List<String> list : freqRev.values()) {
            Collections.sort(list);
            
            for (String s : list) {
                if (cnt++ == k)
                break outer;
                
                result.add(s);
            }
        }
        
        return result;
    }
}