// ����146 LRU����
// ˼·����: ��ϣ��ģ�⻺���ϣ��˫������ģ��LRU����
// Map��� key��node
// -- get ����
//    ����������У������ȡ�����ŵ���β
//    �������û�����У�return-1
// -- put ����
//    �������û�����У�������������ȡ����һ����㣬�����½ڵ���뵽��β
//                              ����ֱ�ӷ��뵽��β
//    ������У��޸�nodeֵ������node�ŵ���β

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
    // ��ϣ���жϻ����Ƿ����
    // ˫����������ģ��LRU
    DList list = new DList();
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // ��key
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.move(node);            
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // û�иû�������
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
            // �иû�������
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