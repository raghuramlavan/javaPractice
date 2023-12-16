import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private int capacity;
    private HashMap<Integer, Integer> hm;
    private LinkedList<Integer> lists;

    public LRUCache(int cap) {
        capacity = cap;
        hm = new HashMap<Integer>();
        lists = new LinkedLists<Integer>();
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            int value = hm.get(key);
            if (lists.contains(key)) {
                lists.remove(key);
                lists.addFirst(key);
            }
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        hm.put(key, value);
        lists.addFirst(key);
        if (lists.size() > capacity) {
            int del = lists.removeLast();
            hm.remove(del);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */