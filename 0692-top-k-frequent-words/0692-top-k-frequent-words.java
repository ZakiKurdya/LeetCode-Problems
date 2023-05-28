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
        
        List<WordFrequency> wordFreqList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet())
            wordFreqList.add(new WordFrequency(entry.getKey(), entry.getValue()));
        
        wordFreqList.sort((a, b) -> {
            if (a.frequency != b.frequency)
                return b.frequency - a.frequency; // descending order by frequency
            else
                return a.word.compareTo(b.word); // ascending order by word (lexicographical)
        });
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(wordFreqList.get(i).word);
        
        return result;
    }
}