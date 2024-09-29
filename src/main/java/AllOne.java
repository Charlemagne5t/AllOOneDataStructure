import java.util.*;

class AllOne {
    int max = 0;
    int min = 0;
    List<Node> storage;
    Map<String, Integer> map;

    public AllOne() {
        storage = new ArrayList<>();
        map = new HashMap<>();
    }

    public void inc(String key) {
        if(!map.containsKey(key)) {
            map.put(key, 0);
            if(storage.isEmpty()){
                storage.add(new Node());
            }
            storage.get(0).stringSet.add(key);
            min = 0;
        }else {
            int oldPos  = map.get(key);
            storage.get(oldPos).stringSet.remove(key);
            if(storage.get(oldPos).stringSet.isEmpty()) {
                if(oldPos == min) {
                    min++;
                }
                storage.set(oldPos, null);
            }
            int newPos = oldPos + 1;
            if(newPos)

        }
    }

    public void dec(String key) {

    }

    public String getMaxKey() {

    }

    public String getMinKey() {

    }
}

class Node {
    Set<String> stringSet = new HashSet<>();
    Node next;
    Node prev;
}