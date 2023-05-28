class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp = timeMap.getOrDefault(key, new TreeMap<>());
        temp.put(timestamp, value);
        
        timeMap.put(key, temp);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        TreeMap<Integer, String> keyMap = timeMap.get(key);
        // greatest key less than or equal to given key
        Integer floorTimestamp = keyMap.floorKey(timestamp);

        if (floorTimestamp == null)
            return "";

        return keyMap.get(floorTimestamp);
    }
}