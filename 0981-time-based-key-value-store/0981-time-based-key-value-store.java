class TimeMap {
    private static class MapNode {
        int timestamp;
        String value;
        
        public MapNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    private Map<String, List<MapNode>> timeMap;
    
    public TimeMap() {
        timeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key))
            timeMap.put(key, new ArrayList());
        
        timeMap.get(key).add(new MapNode(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        
        if (timestamp < timeMap.get(key).get(0).timestamp)
            return "";
    
        // binary search
        int left = 0, right = timeMap.get(key).size();
        
        while (left < right) {
            int mid = (right - left) / 2 + left;
            
            if (timeMap.get(key).get(mid).timestamp <= timestamp)
                left = mid + 1;
            else
                right = mid;
        }

        // no time <= timestamp exists.
        if (right == 0)
            return "";
                
        return timeMap.get(key).get(right - 1).value;
    }
}