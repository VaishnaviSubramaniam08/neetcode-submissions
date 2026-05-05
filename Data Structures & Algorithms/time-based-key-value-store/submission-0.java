
class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            Pair midPair = list.get(mid);

            if (midPair.timestamp == timestamp) {
                return midPair.value;
            } 
            else if (midPair.timestamp < timestamp) {
                result = midPair.value;  
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    class Pair {
        int timestamp;
        String value;

        Pair(int t, String v) {
            timestamp = t;
            value = v;
        }
    }
}