// ����209 ������С�������� 
// ˼·������1.�������ڣ�˫ָ�룩 ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(1)
// ������չ��sum >= target����¼���ȣ�Ȼ�������������������չ
// 2.ǰ׺��+���ֲ��� ʱ�临�Ӷ�O(NlogN) �ռ临�Ӷ�O(N)
// ����numsǰ׺�ͣ�Ȼ����ÿ��ǰ׺��sums[i]Ϊ��㣬sums[i]+targetΪ�յ㣬���ֲ����յ�λ��

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        int left =0, right =0;
        int curSum = 0;
        while(right < nums.length || curSum >= target){
            while(right < nums.length && curSum < target){
                curSum += nums[right];
                right++;
            }
            // ����Ҳ���������sum>=target�Ϳ���break��
            if(curSum >= target){
                min = Math.min(min,right-left);
                curSum -= nums[left];
                left++;
            }else{
                break;
            }
        }
        return min==nums.length+1? 0:min;
    }
    public static void main(String[] args){
        int target = 11 ;
        int [] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }
    
}
