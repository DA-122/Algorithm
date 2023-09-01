// ����1749. ����������͵ľ���ֵ�����ֵ
// ��Ŀ����������һ���������� nums ��һ�������� [numsl, numsl+1, ..., numsr-1, numsr] �� �͵ľ���ֵ Ϊ abs(numsl + numsl+1 + ... + numsr-1 + numsr) ��
// �����ҳ� nums �� �͵ľ���ֵ �������������飨����Ϊ�գ�
// ˼·������ ��̬�滮�� ���ҳ������飬���(����)������С(����)
public class Solution{
    public static void main(String[] args){
        int nums[] = {-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8};
        maxAbsoluteSum(nums);
    }
    public static int maxAbsoluteSum(int[] nums) {
        int res = 0;
        int [] max = new int[nums.length];
        int [] min = new int[nums.length];
        max[0] = Math.max(nums[0],0);
        min[0] = Math.min(nums[0],0);
        res = Math.max(res, max[0]);
        res = Math.max(res, -min[0]);
        for(int i = 1; i < nums.length; i++){
            if(max[i - 1] > 0){
                max[i] = max[i-1]+ nums[i];
            }else{
                max[i] = nums[i];
            }
            if(min[i - 1] < 0){
                min[i] = min[i-1]+ nums[i];
            }else{
                min[i] = nums[i];
            }
            res = Math.max(max[i],res);
            res = Math.max(res,-min[i]);
        }
        return res;
    }
}