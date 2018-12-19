package linked_list.LRUcache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/18
 */

/**
 * @Author liu Ruiqing
 * @Description 利用linkedHashMap的accessorder开启模式直接实现
 * @Date 2018/12/19
 * @Param
 * @return
 **/
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new LinkedHashMap<Integer, Integer>(this.capacity, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer val = lru.get(key);
        if (val == null) {
            return -1;
        }
        return val;
    }

    public void put(int key, int value) {
        lru.put(key,value);
    }
}

/**
 * @Author liu Ruiqing
 * @Description  自定义节点类型 + hashmap实现。设定head,tail都是空，为dummyhead,head指针之后的指针是最老的，tail之前的节点是最新的。容量不够时删除head之后的（与linkedhashmap一致）
 * @Date 2018/12/19
 * @Param
 * @return
 **/
class LRUCacheRaw {
    private class Node{
        Integer key, value;
        Node before, after;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }
    }

    private static final int INITIAL_CAPACITY = ( 1 << 4);
    private int capacity, count;
    private Node head, tail;
    private HashMap<Integer, Node> map;

    public LRUCacheRaw() {
        this.capacity = INITIAL_CAPACITY;
        this.init(this.capacity);
    }

    public LRUCacheRaw(int capacity) {
        this.capacity = capacity;
        this.init(this.capacity);
    }

    private void init (int capacity) {
        this.count = 0;
        map = new HashMap<>(this.capacity);

        this.head = new Node();
        this.tail = new Node();
        head.before = null;
        head.after = tail;
        tail.before = head;
        tail.after = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        afterGet(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //map中没有这一对
        if (node == null) {
            Node newNode = new Node(key,value);

            map.put(key, newNode);
            this.addToTail(newNode);

            count++;

            // 超过初始容量，则删除尾节点
            if (this.count > this.capacity) {
                Node del = removeHead();
                this.map.remove(del.key);
                count--;
            }
        } else {
            // map中有，修改这个值并移至链表末尾
            node.value = value;
            afterGet(node);
        }
    }

    //实现节点移动到末尾：先删除，再加入
    private void afterGet(Node e) {
        if (e != tail) {
            removeNode(e);
            addToTail(e);
        }
    }

    //删除节点的时候，将其引用置为null，便于前后节点被删除后GC
    private void removeNode(Node e) {
        Node b = e.before, a = e.after;
        b.after = a;
        a.before = b;
        e.before = null;
        e.after = null;
    }

    //将该节点加入链表尾部
    private void addToTail(Node e) {
        e.before = tail.before;
        e.after = tail;

        tail.before.after = e;
        tail.before = e;
    }

    //容量不够时删除最老的节点，并返回Key,便于在hashmap中将该节点删除。
    private Node removeHead() {
        Node res = head.after;
        this.removeNode(head.after);
        return res;
    }
}


public class Solution {

    public static void main(String[] args) {
        LRUCacheRaw a = new LRUCacheRaw(2);
        a.put(1,1);
        a.put(2,2);
        System.out.println(a.get(1));
        a.put(3,3);
        System.out.println(a.get(2));
        a.put(4,4);
        System.out.println(a.get(1));
        System.out.println(a.get(3));
        System.out.println(a.get(4));
    }
}
