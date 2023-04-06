// 1590.ʹ������ܱ�P����
/* ����㣺ǰ׺�ͣ�ͬ�����ʣ���ϣ��
 * ����1  y % p = x, (y ? z) % p = 0  �ȼ��� z % p = x
 * ����2 (y - z) % p = x �ȼ��� z % p = (y - x) % p
 * sums[n] % p = 0 ������ɾ��ֱ�ӿ��Ա������� 
 * sums[n] % p = x ���ɶ���һ������Ҫ��һ�����������(j,i]����,sums[i] -sums[j] ʹ�� (sums[i] -sums[j]) % p = x
 * �ɶ���� (sums[i] - sums[j]) % p = x �ȼ��� sums[i] % p = (sums[i]- x)%p
 * ������� sums[n] % p = x, ��Ҫ��һ����̵������飨j,i]ʹ�� sums[j] % p = (sums[i] - x) % p
 */

import java.util.HashMap;
import java.util.Map;

public class MinSubarraySolution {
    // ����
    public static int minSubarray(int[] nums, int p) {
        long sums[] = new long[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            sums[i] =sums[i-1] + nums[i];
        }
        long sum = sums[nums.length-1]; 
        if(sum %p == 0)
            return 0;
        else{
            for(int i = 1; i < nums.length; i++){
                if((sum - sums[i-1]) % p ==0){
                    return i;
                }
                for(int j = i; j < nums.length; j=j+1){
                    if((sum - sums[j] + sums[j-i]) % p == 0)
                        return i;
                }
            }
        }
        return -1;
    }
    // ��ϣ�� ͬ�� �Ż�
    public static int minSubarraySOTA(int[] nums, int p) {
        int x = 0;
        for(int num: nums){
            x = (x+num)%p;   //����д�����Խ��������������֮�ͳ������ͽ��޵�����
        }
        if(x == 0)
            return 0;
        int y = 0;
        int ans = nums.length;
        Map<Integer ,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(y,i);
            y = (y + nums[i])% p;
            if(map.containsKey((y-x+p)%p)){
                ans = Math.min(ans, i - map.get((y-x+p)%p)+1);
            }
        }
        return ans == nums.length? -1:ans;
    }


    public static void main(String[] args){
        int [] testCase = {1000000,1000000,1000000};
        int [] testCase2 = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        System.out.println(minSubarray(testCase2,148));
        System.out.println(minSubarraySOTA(testCase2,148));
    }
}


