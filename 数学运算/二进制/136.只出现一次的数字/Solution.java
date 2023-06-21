// 136.ֻ����һ�ε�����
// ��Ŀ�������ǿ� �������� nums ������ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
// ˼·������1. ��ϣ���ռ临�Ӷ�O(N)��
// 2. ���(�κ�����0���������) ���ռ临�Ӷ�O(1)��

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result^=nums[i];
        }   
        return result;
    }
}