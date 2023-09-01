// ����234.��������
// �ж�����Ԫ���Ƿ����
// ��1���������Ƶ������У�Ȼ��˫ָ���ж�
// ��2��������Ԫ����ջ��Ȼ�����ζԱ�
// ��3���ݹ���жϻ���
// ��1 - ��3 ʱ��ռ临�Ӷȶ���O(n)��
// ��4������ָ�룬��תһ�������Ȼ����жԱ�


public class Solution {
    // �ݹ鷨
    ListNode frontPointer;
    public boolean isPalindromeRecursive(ListNode head) {
        frontPointer = head;
        return recursiveCheck(head);
    }
    public boolean recursiveCheck(ListNode currentNode){
        if(currentNode != null){
            if(!recursiveCheck(currentNode.next)){
                return false;
            }
            if(currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }


    // ����ָ�뷨
    // ��תǰ���
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        // ��תǰ�벿��
        while(fast != null && fast.next != null) {
            ListNode temp = slow.next;
            if(pre != null){
                slow.next = pre;
            }
            pre = slow;
            fast = fast.next.next;
            slow = temp;
        }
        // ��������£�fast��Ϊnull��
        if(fast != null){
            slow = slow.next;
        }
        // slow�������Σ�pre����ǰ���
        while(slow != null){
            if(slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
