class LRUCache {
    class Node
    {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    private int cc;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;
    public LRUCache(int cc) {
        head=new Node(0,0);
        tail=new Node(0,0);
        this.cc=cc;
        map=new HashMap<>();

        head.next=tail;
        tail.prev=head;
    }
    public void insert_front(Node new_node)
    {
        new_node.next=head.next;
        new_node.prev=head;

        head.next.prev=new_node;
        head.next=new_node;
    }
    public void remove_ele(Node node)
    {
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }

        Node node=map.get(key);
        remove_ele(node);
        insert_front(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.value=value;
            remove_ele(node);
            insert_front(node);
        }
        else{
            if(map.size()==cc)
            {
                Node least_recent_used=tail.prev;
                remove_ele(least_recent_used);
                map.remove(least_recent_used.key);
            }
            Node new_node=new Node(key,value);
            insert_front(new_node);
            map.put(key,new_node);
        }
    }
}
