public class MyLinkedList {
    ListNode head = null;
    ListNode tail = null;
    int length = 0;

    // 构造方法
    public MyLinkedList() {

    }
    // 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
    public int get(int index) {
        ListNode node = head;
        for(int i = 0; i <index&&node!=null ;i++){
            node = node.next;
        }
        return node==null? -1:node.val;
    }
    // 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        // 链表为空
        if(tail == null){
           tail =node; 
        }
        length++;
    }
    // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        // 链表为空
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }
    // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }else if(index == length){
            addAtTail(val);
            return;
        }else if(index > length||index < 0){
            return;
        }
        ListNode node = head;
        for(int i = 0; i <index-1&&node!=null ;i++){
            node = node.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
        length++;
    }
    // 如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index) {
        if(index + 1 > length || index < 0 || length==0){
            return;
        }else if(index == 0){
            // 只有一个元素
            if(length==1){
                tail = head.next;
            }
            head = head.next;
            length--;
            return;
        }else if(index == length-1){
            if(length == 1){
                head = null;
                tail = null;
                length--;
                return;
            }
        }
        ListNode node = head;
        for(int i = 0; i < index-1 && node!=null; i++){
            node = node.next;
        }
        if(index == length -1){
            tail = node;
        }
        node.next = node.next.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() { 
    }
    public ListNode(int x) { 
        val = x; 
    }
}