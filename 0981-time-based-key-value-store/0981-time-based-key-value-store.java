class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap temp = map.getOrDefault(key, new TreeMap<Integer, String>());
        temp.put(timestamp, value);
        
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        
        TreeMap<Integer, String> temp = map.get(key);
        Integer idx = (Integer) temp.floorKey(timestamp);
        
        if (idx == null)
            return "";
        
        return temp.get(idx);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */