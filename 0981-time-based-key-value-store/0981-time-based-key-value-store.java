class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp;
        
        if (map.containsKey(key))
            temp = map.get(key);
        else
            temp = new TreeMap<>();
        
        temp.put(timestamp, value);
        
        this.map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        else {
            TreeMap<Integer, String> temp = map.get(key);
            
            if (temp.containsKey(timestamp)) 
                return temp.get(timestamp);
            else if (timestamp < temp.firstKey())
                return "";
            else
                return temp.get(temp.lowerKey(timestamp));
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */