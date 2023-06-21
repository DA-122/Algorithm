// 力扣146 LRU缓存
// 思路分析: 哈希表模拟缓存哈希，双向链表模拟LRU队列
// Map存放 key和node
// -- get 方法
//    如果缓存命中，将结点取出并放到队尾
//    如果缓存没有命中，return-1
// -- put 方法
//    如果缓存没有命中，看满不满，满取出第一个结点，并将新节点加入到队尾
//                              不满直接放入到队尾
//    如果命中，修改node值，并将node放到队尾

import java.util.HashMap;
import java.util.Map;

class Node{
    int val;
    int key;
    Node next;
    Node pre;
    public Node(){

    }
    public Node(int key,int value){
        this.key = key;
        this.val = value;
    }
}

class DList{
    Node head = new Node();
    Node tail = new Node();

    DList(){
        head.next = tail;
        tail.pre = head;
    }
    Node poll(){
        if(head.next == tail){
            return null;
        }
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;
        node.next = null;
        return node;
    }

    Node remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    void move(Node node){
        remove(node);
        addLast(node);
    }

    void addLast(Node node){
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre =node;
    }

}


class LRUCache {
    // 哈希表判断缓存是否存在
    // 双向链表用来模拟LRU
    DList list = new DList();
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // 有key
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.move(node);            
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // 没有该缓存数据
        if(!map.containsKey(key)){
            if(map.size() == capacity){
                Node old = list.poll();
                map.remove(old.key);
                Node node =new Node(key,value);
                map.put(key,node);
                list.addLast(node);
            }else{
                Node node = new Node(key,value);
                list.addLast(node);
                map.put(key,node);
            }
        }else{
            // 有该缓存数据
            Node old = map.get(key);
            old.val = value;
            list.move(old);
        }
    }
}
public class Solution{
    public static void main(String[] args){
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        lru.get(3);
        lru.get(4);
    }
}