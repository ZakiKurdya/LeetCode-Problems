class TimeMap {
    private Map<String, List<Entry>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Entry> entryList = timeMap.getOrDefault(key, new ArrayList<>());
        entryList.add(new Entry(timestamp, value));
        timeMap.put(key, entryList);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        List<Entry> entryList = timeMap.get(key);
        int index = binarySearch(entryList, timestamp);

        if (index == -1)
            return "";

        return entryList.get(index).value;
    }

    // Binary search implementation to find the index of the greatest entry less than or equal to the given timestamp
    private int binarySearch(List<Entry> entryList, int timestamp) {
        int left = 0;
        int right = entryList.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Entry entry = entryList.get(mid);

            if (entry.timestamp <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Helper class to represent an entry with a timestamp and value
    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
