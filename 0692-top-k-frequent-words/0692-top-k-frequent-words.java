class Solution {
    private static class WordFrequency {
        String word;
        int frequency;
        
        WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        
        PriorityQueue<WordFrequency> pq = new PriorityQueue<>((a, b) -> {
            if (a.frequency != b.frequency)
                return a.frequency - b.frequency; // ascending order by frequency
            else
                return b.word.compareTo(a.word); // descending order by word
        });
        
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.add(new WordFrequency(entry.getKey(), entry.getValue()));
            if (pq.size() > k)
                pq.poll();
        }
        
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(0, pq.poll().word);
        
        return result;
    }
}