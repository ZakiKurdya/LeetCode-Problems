class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String anagram : strs) {            
            char[] chars = anagram.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            
            if (!anagrams.containsKey(sortedString)) {
                List<String> group = new ArrayList<>();
                group.add(anagram);
                anagrams.put(sortedString, group);
            } else
                anagrams.get(sortedString).add(anagram);
        }
        
        return new ArrayList<>(anagrams.values());       
    }
}