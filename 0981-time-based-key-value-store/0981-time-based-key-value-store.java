class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new TreeMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> keyMap = timeMap.getOrDefault(key, new TreeMap<>());
        keyMap.put(timestamp, value);
        timeMap.put(key, keyMap);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        TreeMap<Integer, String> keyMap = timeMap.get(key);
        Integer floorTimestamp = keyMap.floorKey(timestamp);

        if (floorTimestamp == null)
            return "";

        return keyMap.get(floorTimestamp);
    }
}