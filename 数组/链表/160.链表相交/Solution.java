// ����160.�����ཻ
// ˼·������ 1.��ϣ��
// 2.˫ָ�루nodeA->headB nodeB->HeadA ���α����ս�������

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA !=null || nodeB!=null){
            if(nodeA == null){
                nodeA = headB;
            }
            if(nodeB == null){
                nodeB = headA;
            }
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}