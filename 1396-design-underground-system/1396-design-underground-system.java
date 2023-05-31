class UndergroundSystem {
    static class Pair {
        String station; 
        int time;
        
        public Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    
    private HashMap<Integer, Pair> check ;
    private HashMap<String, ArrayList<Integer>> dest;
    
    public UndergroundSystem() {
        check = new HashMap<>();
        dest = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        check.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = check.get(id);
        
        String s = p.station + "->" + stationName;
        int diff = t - p.time;
        if (dest.containsKey(s)) {
            ArrayList<Integer> curr = dest.get(s);
            curr.add(diff);
        } else {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(diff);
            dest.put(s, al); 
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String s = startStation + "->"+endStation;
        ArrayList<Integer> curr = dest.get(s);
        double sum = 0;
        for(int i = 0; i < curr.size(); i++)
            sum += curr.get(i);
        if(curr.size() == 0)
            return 0;
        return (double) sum /(double) curr.size();
    }
}
