// 238.���������������ĳ˻�

// ˼·������1.�ֱ����ǰ׺�� ��׺�ͣ�res[i] = pre[i-1] * post[i+1] ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
// ����Ҫ���鴢�棬����ʵ��O��1���ռ�


public class Solution {
     // ǰ׺�� ��׺��

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        prefix[0] = nums[0];
        postfix[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i];
        }
        for(int i = n-2; i >= 0; i--){
            postfix[i] = postfix[i+1] * nums[i];
        }
        int res[] = new int[n];
        res[0]  = postfix[1];
        res[n-1] = prefix[n-2];
        for(int i = 1 ; i < n-1; i++){
            res[i] = prefix[i-1]*postfix[i+1];
        }
        return res;
     } 
    // �ռ��Ż�
    public int[] productExceptSelf2(int[] nums) {
        int res [] = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        res[0] = 1;
        for(int i = 0; i < nums.length - 1; i++){
            prefix = prefix*nums[i];
            res[i+1] = prefix;
        }
        for(int i = nums.length-1; i > 0; i--){
            postfix = postfix*nums[i];
            res[i-1] *= postfix;

        }
        return res;
    } 

}