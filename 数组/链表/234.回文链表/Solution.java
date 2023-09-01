// 力扣234.回文链表
// 判断链表元素是否回文
// 法1：将链表复制到数组中，然后双指针判断
// 法2：将链表元素入栈，然后依次对比
// 法3：递归的判断回文
// 法1 - 法3 时间空间复杂度都是O(n)，
// 法4：快慢指针，反转一半的链表，然后进行对比


public class Solution {
    // 递归法
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


    // 快慢指针法
    // 反转前半段
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        // 反转前半部分
        while(fast != null && fast.next != null) {
            ListNode temp = slow.next;
            if(pre != null){
                slow.next = pre;
            }
            pre = slow;
            fast = fast.next.next;
            slow = temp;
        }
        // 奇数情况下，fast不为null，
        if(fast != null){
            slow = slow.next;
        }
        // slow遍历后半段，pre遍历前半段
        while(slow != null){
            if(slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
