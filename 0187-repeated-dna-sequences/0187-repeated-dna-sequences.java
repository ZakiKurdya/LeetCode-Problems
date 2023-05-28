class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> whole = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            System.out.println(temp);
            if (whole.contains(temp))
                result.add(temp);
            
            whole.add(temp);
        }

        return new ArrayList(result);
    }
}