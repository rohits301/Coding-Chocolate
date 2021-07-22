class LRUCache {
    // Hash Table and DLL
    // get and put in O(1)
    
    Node head = new Node(0, 0); // dummy head
    Node tail = new Node(0, 0); // dummy tail
    
    HashMap<Integer, Node> map = new HashMap<>(); // hm of <int,node> to ensure uniqueness
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node); // LRU manage
            
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // if already exists, remove and put new Node with updated value
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(map.size() == capacity){
            remove(tail.prev);
        }
        
        add(new Node(key, value));
    }
    
    public void add(Node node){
        map.put(node.key, node);
        
        // linking of head and new node
        Node headNext = head.next; /// will be tail, when DLL is empty
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node){
        map.remove(node.key);
        // linking of node.prev and node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private class Node {
        Node prev, next;
        
        int key, value;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */