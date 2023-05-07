public class MyLinkedList {
    ListNode head = null;
    ListNode tail = null;
    int length = 0;

    // ���췽��
    public MyLinkedList() {

    }
    // ��ȡ�������±�Ϊ index �Ľڵ��ֵ������±���Ч���򷵻� -1 ��
    public int get(int index) {
        ListNode node = head;
        for(int i = 0; i <index&&node!=null ;i++){
            node = node.next;
        }
        return node==null? -1:node.val;
    }
    // ��һ��ֵΪ val �Ľڵ���뵽�����е�һ��Ԫ��֮ǰ���ڲ�����ɺ��½ڵ���Ϊ����ĵ�һ���ڵ㡣
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        // ����Ϊ��
        if(tail == null){
           tail =node; 
        }
        length++;
    }
    // ��һ��ֵΪ val �Ľڵ�׷�ӵ���������Ϊ��������һ��Ԫ�ء�
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        // ����Ϊ��
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }
    // ��һ��ֵΪ val �Ľڵ���뵽�������±�Ϊ index �Ľڵ�֮ǰ����� index ��������ĳ��ȣ���ô�ýڵ�ᱻ׷�ӵ������ĩβ����� index �ȳ��ȸ��󣬸ýڵ㽫 ������� �������С�
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
    // ����±���Ч����ɾ���������±�Ϊ index �Ľڵ㡣
    public void deleteAtIndex(int index) {
        if(index + 1 > length || index < 0 || length==0){
            return;
        }else if(index == 0){
            // ֻ��һ��Ԫ��
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