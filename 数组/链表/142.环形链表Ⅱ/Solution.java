// ����142. ��������� ����
// ����ָ��

public class Solution{   
    // ����ָ�� 
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // ��ָ��һ��������,��ָ����һ��
        // ���赱ǰλ����c >=a ���ָ���� f = 2s = c +nb, ��ָ���� s= c+mb
        // ��ָ�����ָ����� s = (n-m)b
        // ����ָ��ֱ����� 2(n-m) �� (n-m)��b�ܳ�
        // ��ʱ������ÿ���ָ��ֱ���a���ȣ����ҵ�������ڣ�����aδ֪
        // ����ָ��ָ��head������ָ��ֱ�ÿ����һ�����ٴ��ط�ʱ
        // �� f = a , s = a + (n-m)b��
        // �ý�
        while(fast!=null&&fast.next!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null||fast.next ==null){
            return null;
        }
        fast = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    // ��ϣ��ⷨ 
    public ListNode detectCycle1(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode node = head;
        int pos = -1;
        while(!map.containsKey(node)&&node!=null){
            pos++;
            map.put(node,pos);
            node = node.next;
        }
        if(pos == -1){
            return null;
        }else{
            return node;
        }
    }
}