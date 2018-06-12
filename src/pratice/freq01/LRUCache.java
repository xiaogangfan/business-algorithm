package pratice.freq01;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by anduo on 17-3-14.
 */
public class LRUCache<K, V> {
    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev = null;
        private Node<K, V> next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private final int capacity;
    private int size;
    private Node<K, V> head;
    private Node<K, V> tail;
    private ConcurrentHashMap<K, Node<K, V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node<>((K) null, (V) null);
        tail = new Node<>((K) null, (V) null);
        head.next = tail;
        tail.prev = head;
        this.map = new ConcurrentHashMap<>(capacity);
    }

    public <V> V get(K key) {
        Node<K, V> node = (Node<K, V>) map.get(key);
        if (node == null) {
            return null;
        } else {// update visited
            remove(node);
            insert(node);
            return node.value;
        }
    }

    public void set(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            insert(node);
            size++;
            if (size > capacity) {
                //remove dummy tails's prev
                map.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
        }
    }


    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //insert betwean dummy head and old real head
    private void insert(Node node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

}
