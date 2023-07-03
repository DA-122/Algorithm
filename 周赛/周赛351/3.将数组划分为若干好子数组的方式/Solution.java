// ����351. �����黮��Ϊ���ɺ�������ķ�ʽ
// ˼·�������򵥱�����ע��Խ��
public class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = 1000000000+7;
        long res = 1;
        int pre = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(pre != -1){
                    res = (res * (i - pre)) % MOD;
                }
                pre = i;
            }
        }
        return pre == -1?  0 : (int)(res % MOD);
        
    }
}