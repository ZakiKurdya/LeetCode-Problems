class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : words)
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        
        TreeMap<Integer, PriorityQueue<String>> freqRev = new TreeMap(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            PriorityQueue<String> temp;
            
            if (!freqRev.containsKey(entry.getValue()))
                temp = new PriorityQueue<>();
            else
                temp = freqRev.get(entry.getValue());
            
            temp.add(entry.getKey());
            
            freqRev.put(entry.getValue(), temp);
        }
        
        List<String> result = new ArrayList<>();
        int cnt = 0;
        
        outer:
        for (PriorityQueue<String> pq : freqRev.values()) {
            while (!pq.isEmpty()) {
                if (cnt++ == k)
                    break outer;
                
                result.add(pq.poll());
            }
        }
        
        return result;
    }
}