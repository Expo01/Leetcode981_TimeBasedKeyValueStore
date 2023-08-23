import java.util.HashMap;

class TimeMap {
    HashMap<String, HashMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<String, HashMap<Integer, String>>(); // outer map with value of inner map
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) { // if key doesn't exist, then put the key into the outer map and its value will
            keyTimeMap.put(key, new HashMap<Integer, String>()); // be a new empty inner map to contain its time stamp and value
        }

        keyTimeMap.get(key).put(timestamp, value); // inner hashmap retrived from outer key and we put the new timestamp key
        // in and the associated value
    }

    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        for (int currTime = timestamp; currTime >= 1; --currTime) { // suppose we querry for stock value on 8/24/23 but the
            // most recent price is stamped for 8/21/23, we decrement back from requested timestamp until a logged
            // time stamp is found and then return value at that stamp
                      if (keyTimeMap.get(key).containsKey(currTime)) {
                return keyTimeMap.get(key).get(currTime);
            }
        }

        // would only occur if no time stamp ever added or if stamp <1
        return "";
    }
}