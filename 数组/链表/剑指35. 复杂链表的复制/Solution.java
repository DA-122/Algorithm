// ��ָOffer35. ��������ĸ���
// ����������ֻ��nextָ�룬���и�randomָ��
import java.util.HashMap;
import java.util.Map;


public class Solution{
    //����1  ��ϣ��+���� ʱ�� O(N) �ռ�O(N)
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node curNewNode = newHead;
        Node curNode = head;
        // ͷ�ڵ����map
        map.put(curNode,curNewNode);
        while(curNode.next!=null){
            Node newNext= new Node(curNode.next.val);
            curNewNode.next= newNext;
            curNode = curNode.next;
            curNewNode = curNewNode.next;
            map.put(curNode,curNewNode);
        }
        // ���һ���ڵ����map
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

    // �ݹ�+��ϣ��
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