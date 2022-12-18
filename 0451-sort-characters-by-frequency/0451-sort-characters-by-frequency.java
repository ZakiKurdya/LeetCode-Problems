class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        Map<Character, Integer> temp = freq.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> -i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
            sb.append(entry.getKey().toString().repeat(entry.getValue()));
        }
        return sb.toString();

    }
}