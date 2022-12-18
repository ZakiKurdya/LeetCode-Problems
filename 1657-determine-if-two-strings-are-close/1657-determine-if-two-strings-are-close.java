class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: word1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 1) + 1);
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: word2.toCharArray())
            map2.put(c, map2.getOrDefault(c, 1) + 1);

        List<Integer> set = new ArrayList<>();
        for (int num : map1.values())
            set.add(num);
        Collections.sort(set);
        List<Integer> set2 = new ArrayList<>();
        for (int num : map2.values())
            set2.add(num);    
                Collections.sort(set2);


        Set<Character> set11 = new HashSet<>();
        for (char c : word1.toCharArray())
            set11.add(c);

        Set<Character> set22 = new HashSet<>();
        for (char c : word2.toCharArray())
            set22.add(c);    
        
        
        
        return set.equals(set2) && set11.equals(set22);

    
    }
}