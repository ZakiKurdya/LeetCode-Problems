class Solution {
    static class Pair {
        int f;
        char c;

        public Pair(int f, char c) {
            this.f = f;
            this.c = c;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.f - a.f);

        for (Map.Entry<Character, Integer> ent : freq.entrySet()) {
            Pair temp = new Pair(ent.getValue(), ent.getKey());
            
            pq.add(temp);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            Pair p1 = pq.poll(), p2 = pq.poll();
            
            sb.append(p1.c);
            if (p1.f - 1 != 0) {
                p1.f--;
                pq.add(p1);
            }
            
            if (p2 != null) {
                sb.append(p2.c);
                if (p2.f - 1 != 0) {
                    p2.f--;
                    pq.add(p2);
                }
            }
        }

        if (pq.size() == 0)
            return sb.toString();
        else
            return "";    
    }
}