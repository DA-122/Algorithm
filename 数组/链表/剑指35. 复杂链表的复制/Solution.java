// 剑指Offer35. 复杂链表的复制
// 复杂链表：不只有next指针，还有个random指针
import java.util.HashMap;
import java.util.Map;


public class Solution{
    //方法1  哈希表+迭代 时间 O(N) 空间O(N)
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node curNewNode = newHead;
        Node curNode = head;
        // 头节点加入map
        map.put(curNode,curNewNode);
        while(curNode.next!=null){
            Node newNext= new Node(curNode.next.val);
            curNewNode.next= newNext;
            curNode = curNode.next;
            curNewNode = curNewNode.next;
            map.put(curNode,curNewNode);
        }
        // 最后一个节点加入map
        map.put(curNode,curNewNode);
        curNode = head;
        curNewNode = newHead;
        while(curNode!=null){
            curNewNode.random = map.get(curNode.random);
            curNode = curNode.next;
            curNewNode = curNewNode.next;
        }
        return newHead;
    }

    // 递归+哈希，
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }



}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}