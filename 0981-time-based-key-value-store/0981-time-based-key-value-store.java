class TimeMap extends TimeMap3<String, String> {
        protected String getDefaultValue() {
            return "";
        }
    }

     class TimeMap3<K, V> {

        private static class TimeMapNode<V> {
            V value;
            int timestamp;

            public TimeMapNode(V value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        private final Map<K, ArrayList<TimeMapNode<V>>> timeMap = new HashMap<>();

        public TimeMap3() { }

        public void set(K key, V value, int timestamp) {
            timeMap.computeIfAbsent(key, (v) -> new ArrayList<>())
                    .add(new TimeMapNode<>(value, timestamp));
        }

        public V get(K key, int timestamp) {
            ArrayList<TimeMapNode<V>> values = timeMap.get(key);
            if (values == null || values.isEmpty()) {
                return getDefaultValue();
            }

            int start = 0;
            int end = values.size() - 1;
            if (timestamp < values.get(start).timestamp ) {
                return getDefaultValue();
            }
            if (timestamp >= values.get(end).timestamp) {
                return values.get(end).value;
            }
            while (start <= end) {
                int mid = (start + end)/2;
                TimeMapNode<V> midValue = values.get(mid);
                if (midValue.timestamp == timestamp) {
                    return midValue.value;
                } else if (midValue.timestamp > timestamp) {
                    end = mid - 1;
                } else {
                    // midValue.timestamp < timestamp
                    start = mid + 1;
                }
            }
            return values.get(end).value;
        }

        protected V getDefaultValue() {
            return null;
        }

    }