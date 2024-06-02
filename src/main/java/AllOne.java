import java.util.*;

public class AllOne {
    Map<String, Integer> wordCount = new HashMap<>();
    Deque<Integer> maxIndex = new ArrayDeque<>();
    Node[] nodes = new Node[100_000];
    Node maxNode = null;
    Node minNode = null;

    public AllOne() {
        
    }
    
    public void inc(String key) {
        int c = wordCount.getOrDefault(key, 0);
        c++;
        wordCount.put(key, c);

       if(nodes[c] == null) {
           nodes[c] = new Node(c);
       }
       nodes[c].set.add(key);

       if(nodes[c - 1] != null) {
           nodes[c].prev = nodes[c - 1];
           nodes[c].next = nodes[c - 1].next == nodes[c] ? nodes[c].next : nodes[c - 1].next;
           nodes[c - 1].next = nodes[c];

           nodes[c - 1].set.remove(key);

           if(nodes[c - 1].set.isEmpty()) {
               nodes[c].prev = nodes[c - 1].prev;
               if(nodes[c].prev != null) {
                   nodes[c].prev.next = nodes[c];
               }
               nodes[c - 1] = null; //needed?
           }
       }else {
           if(minNode != null && minNode.index != 1){
               nodes[c].next = minNode;
               minNode.prev = nodes[c];
           }
       }

       if(nodes[c].next == null) {
           maxNode = nodes[c];
       }
       if(nodes[c].prev == null) {
           minNode = nodes[c];
       }

    }
    
    public void dec(String key) {
        int c = wordCount.get(key);
        c--;
        if(c != 0){
            wordCount.put(key, c);
        }else {
            wordCount.remove(key);
        }
        if(nodes[c] == null) {
            nodes[c] = new Node(c);
        }
        nodes[c].set.add(key);

        nodes[c].next = nodes[c + 1];
        nodes[c].prev = nodes[c + 1].prev == nodes[c] ? nodes[c].prev : nodes[c + 1].prev;
        nodes[c + 1].prev = nodes[c];

        nodes[c + 1].set.remove(key);

        if(nodes[c + 1].set.isEmpty()) {
            nodes[c].next = nodes[c + 1].next;
            if(nodes[c].next != null) {
                nodes[c].next.prev = nodes[c];
            }
            nodes[c + 1] = null;
        }
        if(c == 0) {
            if(nodes[c].next == null) {
                maxNode = null;
                minNode = null;

            }else {
                nodes[c].next.prev = null;
                minNode  = nodes[c].next;
            }
            nodes[c] = null;
            return;
        }
        if(nodes[c].next == null) {
            maxNode = nodes[c];
        }
        if(nodes[c].prev == null) {
            minNode = nodes[c];
        }
    }
    
    public String getMaxKey() {
        String res = "";
        if(maxNode != null){
            for(String s : maxNode.set) {
                res = s;
                break;
            }
        }
        return res;
    }
    
    public String getMinKey() {
        String res = "";
        if(minNode != null){
            for(String s : minNode.set) {
                res = s;
                break;
            }
        }
        return res;
    }
}

class Node {
    int index;
    Node prev;
    Node next;
    Set<String> set = new HashSet<>();

    public Node(int index) {
        this.index = index;
    }
}