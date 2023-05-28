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
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<MapNode> temp = timeMap.getOrDefault(key, new ArrayList<>());
        temp.add(new MapNode(timestamp, value));
        
        timeMap.put(key, temp);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        List<MapNode> temp = timeMap.get(key);
        
        int index = lowerBound(temp, timestamp);

        if (index == -1)
            return "";

        return temp.get(index).value;
    }

    // greatest timestamp less than or equal to the given timestamp
    private int lowerBound(List<MapNode> list, int timestamp) {
        int left = 0, right = list.size() - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            MapNode item = list.get(mid);

            if (item.timestamp <= timestamp) {
                result = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return result;
    }
}
