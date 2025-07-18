package practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapVSSynchronizedMap {
    public static void main(String[] args) {
        // Thread-safe but coarse-grained (global lock)
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

// Thread-safe with fine-grained locks (higher concurrency)
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
    }
}
